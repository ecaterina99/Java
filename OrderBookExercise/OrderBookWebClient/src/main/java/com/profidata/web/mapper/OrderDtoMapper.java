package com.profidata.web.mapper;

import com.profidata.application.command.CancelOrderCommand;
import com.profidata.application.command.CreateOrderCommand;
import com.profidata.domain.model.Order;
import com.profidata.web.dto.CancelOrderRequestDTO;
import com.profidata.web.dto.CreateOrderRequestDTO;
import com.profidata.web.dto.CreateOrderResponseDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class OrderDtoMapper {

    public CreateOrderCommand toCommand(CreateOrderRequestDTO dto) {
        return new CreateOrderCommand(
                dto.investmentCcy(),
                dto.counterCcy(),
                dto.buy(),
                BigDecimal.valueOf(dto.limit()),
                LocalDate.parse(dto.validUntil(), DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        );
    }

    public CancelOrderCommand toCommand(CancelOrderRequestDTO dto) {
        return new CancelOrderCommand(dto.id());
    }

    public CreateOrderResponseDTO toDto(Order order) {
        return new CreateOrderResponseDTO(
                order.id().value(),
                order.pair().ccy1(),
                order.pair().ccy2(),
                order.buy(),
                order.limit().value().doubleValue(),
                order.validUntil().value().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        );
    }
}