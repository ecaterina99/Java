package com.profidata.domain.service;

import com.profidata.domain.exception.MarketRateNotFoundException;
import com.profidata.domain.model.FXRate;
import com.profidata.domain.model.Order;
import com.profidata.domain.valueObject.CurrencyPair;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

/*
Logica domeniului care nu aparține unei singure entități.
Ex.: „Calcularea reducerilor pentru client”.
 */

@Service
public class OrderDomainService {

    // mid rate = (bid + ask) / 2
    public static BigDecimal getMarketRate(List<FXRate> rates, String first, String second) {

        for (FXRate rate : rates) {
            String c1 = rate.pair().ccy1();
            String c2 = rate.pair().ccy2();

            if(c1.equals(first) && c2.equals(second)) {
                return rate.bid()
                        .add(rate.ask())
                        .divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
            }
            if (c1.equals(second) && c2.equals(first)) {
                BigDecimal mid = rate.ask()
                        .add(rate.bid()).divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
                return BigDecimal.valueOf(1).divide(mid, RoundingMode.HALF_UP);
            }
        }
        throw new MarketRateNotFoundException(first, second);
    }

    // distance = |limit - marketRate|
    public BigDecimal calculateDistance(Order order, List<FXRate> rates) {
        var mr = getMarketRate(rates, order.pair().ccy1(), order.pair().ccy2());
        return order.limit().value().subtract(mr).abs();
    }

    // sort orders by currency pair & distance
    public List<Order> sortOrdersByDistance(List<Order> orders, List<FXRate> rates) {
        return orders.stream()
                .sorted(Comparator
                        .comparing((Order o) -> o.pair().ccy1())
                        .thenComparing(o -> o.pair().ccy2())
                        .thenComparing(o -> calculateDistance(o, rates))
                )
                .toList();
    }
}