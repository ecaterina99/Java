package com.profidata.infrastructure.client;

import com.profidata.domain.model.Order;
import com.profidata.infrastructure.mapper.OrderMapper;
import com.profidata.web.dto.CreateOrderResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
@RequiredArgsConstructor
public class OrderServiceClient {

    private final WebClient webClient;
    private final OrderMapper mapper;

    public Mono<Order> createOrder(Order domainOrder) {

        var request = mapper.toExternalRequest(domainOrder);

        return webClient.post()
                .uri("/createOrder")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateOrderResponseDTO.class)
                .map(mapper::toDomain);
    }

    public Mono<List<Order>> getOrders() {
        return webClient.get()
                .uri("/retrieveOrders")
                .retrieve()
                .bodyToFlux(CreateOrderResponseDTO.class)
                .map(mapper::toDomain)
                .collectList();
    }

    public Mono<Boolean> cancelOrder(String id) {
        return webClient.post()
                .uri("/cancelOrder")
                .bodyValue(id)
                .retrieve()
                .bodyToMono(String.class)
                .map(res -> res.equalsIgnoreCase("true"));
    }

}