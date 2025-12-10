package com.profidata.domain.valueObject;

import java.time.LocalDate;
import java.util.Objects;
//Nu au identitate proprie. Sunt folosite pentru valori pure
public record ValidUntil(LocalDate value) {
    public ValidUntil {
        Objects.requireNonNull(value);
    }
}