package com.example.util;

import com.example.dto.CreateOrderResponseDTO;
import com.example.dto.CurrencyPairDTO;
import com.example.dto.FXRateDTO;
import com.example.exceptions.UnsupportedCurrencyPairException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FXCalculatorTest {

    private FXRateDTO rate(String c1, String c2, double ask, double bid) {
        CurrencyPairDTO pair = new CurrencyPairDTO();
        pair.setCcy1(c1);
        pair.setCcy2(c2);

        FXRateDTO dto = new FXRateDTO();
        dto.setCcyPair(pair);
        dto.setAsk(ask);
        dto.setBid(bid);

        return dto;
    }

    @Test
    void testGetMarketRate_DirectPair()  throws Exception {
        List<FXRateDTO> rates = List.of(rate("USD", "EUR", 1.12, 1.10));
        double result = FXCalculator.getMarketRate(rates, "USD", "EUR");

        assertEquals(1.11, result, 1e-9);
    }

    @Test
    void testGetMarketRate_ReversePair()  throws Exception {
        List<FXRateDTO> rates = List.of(rate("EUR", "USD", 1.20, 1.18));

        double result = FXCalculator.getMarketRate(rates, "USD", "EUR");

        assertEquals(1.0 / 1.19, result, 1e-9);
    }

    @Test
    void testGetMarketRate_UnsupportedPairThrows() {
        List<FXRateDTO> rates = List.of(rate("USD", "EUR", 1.12, 1.10));

        assertThrows(UnsupportedCurrencyPairException.class, () -> FXCalculator.getMarketRate(rates, "GBP", "JPY"));
    }

    @Test
    void testCalculateDistance() throws Exception {
        FXRateDTO fx = rate("USD", "EUR", 1.12, 1.10);
        List<FXRateDTO> rates = List.of(fx);

        CreateOrderResponseDTO order = new CreateOrderResponseDTO();
        order.setInvestmentCcy("USD");
        order.setCounterCcy("EUR");
        order.setLimit(1.20);

        double distance = FXCalculator.calculateDistance(rates, order);

        assertEquals(0.09, distance, 1e-9);
    }
}
