package com.example.dto;

public class FXRateDTO {

    private double ask;
    private double bid;
    private CurrencyPairDTO ccyPair;


    public FXRateDTO() {
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public CurrencyPairDTO getCcyPair() {
        return ccyPair;
    }

    public void setCcyPair(CurrencyPairDTO ccyPair) {
        this.ccyPair = ccyPair;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

}
