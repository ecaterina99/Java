package com.profidata.domain.model;

import com.profidata.domain.valueObject.CurrencyPair;

import java.math.BigDecimal;
//Obiecte care au o identitate unică.
//FXRate este identificat prin CurrencyPair → deci este entitate.

public record FXRate(
        CurrencyPair pair,
        BigDecimal bid,
        BigDecimal ask
) {}