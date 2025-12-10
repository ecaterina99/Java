package com.profidata.application.service;

import com.profidata.application.command.CancelOrderCommand;
import com.profidata.application.command.CreateOrderCommand;
import com.profidata.application.exception.UnsupportedCurrencyPairException;
import com.profidata.domain.model.Order;
import com.profidata.domain.service.OrderDomainService;
import com.profidata.domain.valueObject.CurrencyPair;
import com.profidata.domain.valueObject.Limit;
import com.profidata.domain.valueObject.ValidUntil;
import com.profidata.infrastructure.client.OrderServiceClient;
import com.profidata.infrastructure.client.RateServiceClient;
import com.profidata.web.dto.OrderViewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/*
Orchestrare, coordonare a fluxului dintre modele și servicii.
Fără logică de business în acest layer.

 */

@Service
@RequiredArgsConstructor
public class OrderApplicationService {

    private final OrderServiceClient orderClient;
    private final RateServiceClient rateClient;
    private final OrderDomainService orderDomainService;

    public Mono<Order> createOrder(CreateOrderCommand cmd) {

        return rateClient.getSupportedPairs()
                .flatMap(pairs -> {

                    boolean supported = pairs.stream()
                            .anyMatch(p ->
                                    p.ccy1().equalsIgnoreCase(cmd.investmentCcy()) &&
                                            p.ccy2().equalsIgnoreCase(cmd.counterCcy())
                            );

                    if (!supported) {
                        return Mono.error(new UnsupportedCurrencyPairException(cmd.investmentCcy(), cmd.counterCcy()));
                    }

                    // construim domain model DOAR dacă e valid
                    CurrencyPair pair = new CurrencyPair(cmd.investmentCcy(), cmd.counterCcy());
                    Limit limit = new Limit(cmd.limit());
                    ValidUntil until = new ValidUntil(cmd.validUntil());

                    Order order = new Order(
                            null,
                            pair,
                            cmd.buy(),
                            limit,
                            until
                    );

                    return orderClient.createOrder(order);
                });
    }


    public Flux<OrderViewDTO> getAllOrders() {
        return orderClient.getOrders()
                .zipWith(rateClient.getRates())
                .flatMapMany(tuple -> {

                    var orders = tuple.getT1();
                    var rates = tuple.getT2();

                    var sorted = orderDomainService.sortOrdersByDistance(orders, rates);

                    return Flux.fromStream(
                            sorted.stream().map(order -> {

                                BigDecimal distance = orderDomainService.calculateDistance(order, rates);

                                return new OrderViewDTO(
                                        order.id().value(),
                                        order.pair().ccy1(),
                                        order.pair().ccy2(),
                                        order.buy(),
                                        order.limit().value().doubleValue(),
                                        order.validUntil().value().toString(),
                                        distance.doubleValue()
                                );
                            })
                    );
                });
    }


    public Mono<Boolean> cancelOrder(CancelOrderCommand cmd) {
        return orderClient.cancelOrder(cmd.id());
    }
}