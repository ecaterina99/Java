package com.example.exceptions;

/**
 * Custom exception which happens  when the user tries to create an order
 * for a pair that is not supported by the backend.
 */
public class UnsupportedCurrencyPairException extends RuntimeException {
    public UnsupportedCurrencyPairException(String firstCcy, String secondCcy) {
        super("No market rate for this currency pair: " + firstCcy + " / " + secondCcy);
    }
}
