package com.profidata.web.dto;

public record FxRateDTO (
    double ask,
    double bid,
    CurrencyPairDTO ccyPair){
}


