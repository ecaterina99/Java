package com.profidata.infrastructure.mapper;

import com.profidata.domain.model.Order;
import com.profidata.domain.valueObject.CurrencyPair;
import com.profidata.domain.valueObject.Limit;
import com.profidata.domain.valueObject.OrderId;
import com.profidata.domain.valueObject.ValidUntil;
import com.profidata.web.dto.CreateOrderRequestDTO;
import com.profidata.web.dto.CreateOrderResponseDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class OrderMapper {

    public CreateOrderRequestDTO toExternalRequest(Order domain) {
        return new CreateOrderRequestDTO(
                domain.pair().ccy1(),
                domain.pair().ccy2(),
                domain.buy(),
                domain.limit().value().doubleValue(),
                domain.validUntil().value().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        );
    }

    public Order toDomain(CreateOrderResponseDTO dto) {
        return new Order(
                new OrderId(dto.id()),
                new CurrencyPair(dto.investmentCcy(), dto.counterCcy()),
                dto.buy(),
                new Limit(BigDecimal.valueOf(dto.limit())),
                new ValidUntil(LocalDate.parse(
                        dto.validUntil(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy")
                ))
        );
    }
}