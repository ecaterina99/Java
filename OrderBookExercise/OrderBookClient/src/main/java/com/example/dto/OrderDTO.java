package com.example.dto;

public class OrderDTO {
    private String investmentCcy;
    private String counterCcy;
    private boolean buy;
    private double limit;
    private String validUntil;
    private String id;

    public OrderDTO() {
    }

    public String getInvestmentCcy() {
        return investmentCcy;
    }

    public boolean isBuy() {
        return buy;
    }

    public String getCounterCcy() {
        return counterCcy;
    }

    public double getLimit() {
        return limit;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public String getId() {
        return id;
    }
}

