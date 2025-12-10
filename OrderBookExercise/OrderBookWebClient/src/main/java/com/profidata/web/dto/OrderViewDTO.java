package com.profidata.web.dto;

public record OrderViewDTO(
        String id,
        String investmentCcy,
        String counterCcy,
        boolean buy,
        double limit,
        String validUntil,
        double distance
) {}
