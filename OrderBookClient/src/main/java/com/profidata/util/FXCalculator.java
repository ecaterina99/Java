package com.profidata.util;

import com.profidata.DTO.CreateOrderResponseDTO;
import com.profidata.DTO.FXRateDTO;

import java.util.List;

public class FXCalculator {

    public static double getMarketRate(List<FXRateDTO> rates, String first, String second) throws Exception {

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
        throw new Exception("No market rate for: " + first + " / " + second);
    }

    public static double calculateDistance(List<FXRateDTO> rates, CreateOrderResponseDTO o) throws Exception {
        double marketRate = getMarketRate(
                rates,
                o.getInvestmentCcy(),
                o.getCounterCcy()
        );
        return Math.abs(o.getLimit() - marketRate);
    }
}
