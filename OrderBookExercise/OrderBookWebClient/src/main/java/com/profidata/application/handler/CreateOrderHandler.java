package com.profidata.application.handler;

import com.profidata.application.command.CreateOrderCommand;
import com.profidata.application.service.OrderApplicationService;
import com.profidata.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateOrderHandler {

    private final OrderApplicationService service;

    public Mono<Order> handle(CreateOrderCommand command) {
        return service.createOrder(command);
    }
}