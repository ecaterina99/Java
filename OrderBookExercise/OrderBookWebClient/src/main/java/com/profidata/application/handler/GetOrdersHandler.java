package com.profidata.application.handler;

import com.profidata.application.service.OrderApplicationService;
import com.profidata.web.dto.OrderViewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class GetOrdersHandler {

    private final OrderApplicationService service;

    public Flux<OrderViewDTO> handle() {
        return service.getAllOrders();
    }
}