package com.example.util;

import com.example.dto.CreateOrderResponseDTO;
import com.example.dto.FXRateDTO;
import com.example.exceptions.UnsupportedCurrencyPairException;

import java.util.List;
/**
 * Helper class that contains basic FX calculation logic
 */
public class FXCalculator {

    public static double getMarketRate(List<FXRateDTO> rates, String first, String second) {

        for (FXRateDTO r : rates) {
            String c1 = r.getCcyPair().getCcy1();
            String c2 = r.getCcyPair().getCcy2();

            if (c1.equals(first) && c2.equals(second)) {
                return (r.getAsk() + r.getBid()) / 2.0;
            }

            if (c1.equals(second) && c2.equals(first)) {
                double mid = (r.getAsk() + r.getBid()) / 2.0;
                return 1.0 / mid;
            }
        }
        throw new UnsupportedCurrencyPairException(first, second);
    }

    public static double calculateDistance(List<FXRateDTO> rates, CreateOrderResponseDTO o) {
        double marketRate = getMarketRate(
                rates,
                o.getInvestmentCcy(),
                o.getCounterCcy()
        );
        return Math.abs(o.getLimit() - marketRate);
    }
}
