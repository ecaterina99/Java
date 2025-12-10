package com.profidata.web.dto;

public record CreateOrderResponseDTO(
        String id,
        String investmentCcy,
        String counterCcy,
        boolean buy,
        double limit,
        String validUntil
) {}