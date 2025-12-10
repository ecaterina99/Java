package com.profidata.web.controller;

import com.profidata.application.command.CancelOrderCommand;
import com.profidata.application.handler.CancelOrderHandler;
import com.profidata.application.handler.CreateOrderHandler;
import com.profidata.application.handler.GetOrdersHandler;
import com.profidata.domain.valueObject.OrderId;
import com.profidata.web.dto.CancelOrderRequestDTO;
import com.profidata.web.dto.CreateOrderRequestDTO;
import com.profidata.web.dto.CreateOrderResponseDTO;
import com.profidata.web.dto.OrderViewDTO;
import com.profidata.web.mapper.OrderDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderHandler handler;
    private final GetOrdersHandler getOrdersHandler;
    private final CancelOrderHandler cancelOrderHandler;
    private final OrderDtoMapper mapper;

    @PostMapping
    public Mono<CreateOrderResponseDTO> createOrder(@RequestBody CreateOrderRequestDTO dto) {
        var cmd = mapper.toCommand(dto);
        return handler.handle(cmd).map(mapper::toDto);
    }

    @GetMapping
    public Flux<OrderViewDTO> getOrders() {
        return getOrdersHandler.handle();
    }

    @PostMapping("/cancel")
    public Mono <Boolean> cancelOrder(@RequestBody CancelOrderRequestDTO dto) {
        var cmd = mapper.toCommand(dto);
        return  cancelOrderHandler.handle(cmd);
    }

}
