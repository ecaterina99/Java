package com.profidata.application.command;

import java.math.BigDecimal;
import java.time.LocalDate;
//Comanda este un agregat, iar Order este root; produsele din comandă sunt elemente interne.
public record CreateOrderCommand(
        String investmentCcy,
        String counterCcy,
        boolean buy,
        BigDecimal limit,
        LocalDate validUntil
) {}