package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/** FX rate entry which contains a currency pair, bid and ask prices
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FXRateDTO {
    private double ask;
    private double bid;
    private CurrencyPairDTO ccyPair;
}
