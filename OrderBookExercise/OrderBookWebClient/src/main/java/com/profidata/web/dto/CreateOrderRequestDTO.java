package com.profidata.web.dto;
//Acest DTO este forma CRUD primită din UI, nu este domain.
public record CreateOrderRequestDTO(
        String investmentCcy,
        String counterCcy,
        boolean buy,
        double limit,
        String validUntil
) {}