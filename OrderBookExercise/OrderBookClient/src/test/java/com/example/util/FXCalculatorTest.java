package com.example.util;

import com.example.dto.CreateOrderResponseDTO;
import com.example.dto.CurrencyPairDTO;
import com.example.dto.FXRateDTO;
import com.example.exceptions.UnsupportedCurrencyPairException;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FXCalculatorTest {

    private FXRateDTO rate(String currency1, String currency2, double ask, double bid) {

        CurrencyPairDTO pair = new CurrencyPairDTO();
        pair.setCcy1(currency1);
        pair.setCcy2(currency2);

        FXRateDTO dto = new FXRateDTO();
        dto.setCcyPair(pair);
        dto.setAsk(ask);
        dto.setBid(bid);
        return dto;
    }

    @Test
    public void testGetMarketRate_DirectPair() {
        List<FXRateDTO> rates = List.of(rate("EUR", "USD", 1.2, 1.6));
        double result = FXCalculator.getMarketRate(rates, "EUR", "USD");
        assertEquals(1.4, result, 1e-9);
    }

    @Test
    public void testGetMarketRate_ReversePair() {
        List<FXRateDTO> rates = List.of(rate("EUR", "USD", 1.2, 1.6));
        double result = FXCalculator.getMarketRate(rates, "USD", "EUR");
        assertEquals(1 / 1.4, result, 1e-9);
    }

    @Test
    public void testGetMarketRate_UnsupportedCurrencyPairThrows() {
        List<FXRateDTO> rates = List.of(rate("EUR", "USD", 1.2, 1.6));
        assertThrows(UnsupportedCurrencyPairException.class, () -> FXCalculator.getMarketRate(rates, "EUR", "RON"));
    }


    @Test
    public void testCalculateDistance() {
        List<FXRateDTO> rates = List.of(rate("EUR", "USD", 1.2, 1.6));
        CreateOrderResponseDTO order = new CreateOrderResponseDTO();
        order.setCounterCcy("USD");
        order.setInvestmentCcy("EUR");
        order.setLimit(1.9);
        double result = FXCalculator.calculateDistance(rates, order);

        assertEquals(0.5, result, 1e-9);

    }

}