package com.profidata.domain.exception;

import com.profidata.domain.valueObject.CurrencyPair;

public class MarketRateNotFoundException extends RuntimeException {
    public MarketRateNotFoundException(String first, String second) {
        super("Market rate not found for pair: " + first + "/" + second);
    }
}