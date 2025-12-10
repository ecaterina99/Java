package com.profidata.domain.valueObject;

import java.math.BigDecimal;
import java.util.Objects;
//Nu au identitate proprie. Sunt folosite pentru valori pure
public record Limit(BigDecimal value) {
    public Limit {
        Objects.requireNonNull(value);
        if (value.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Limit must be positive");
    }
}