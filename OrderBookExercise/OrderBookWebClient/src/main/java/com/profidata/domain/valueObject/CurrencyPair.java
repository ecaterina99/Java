package com.profidata.domain.valueObject;

import java.util.Objects;
//Nu au identitate proprie. Sunt folosite pentru valori pure
public record CurrencyPair(String ccy1, String ccy2) {
    public CurrencyPair {
        Objects.requireNonNull(ccy1);
        Objects.requireNonNull(ccy2);

        if (ccy1.length() != 3 || ccy2.length() != 3)
            throw new IllegalArgumentException("Currency codes must have 3 letters");
    }
}