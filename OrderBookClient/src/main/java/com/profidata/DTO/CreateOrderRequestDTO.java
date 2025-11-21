package com.profidata.DTO;

public class CreateOrderRequestDTO {
    private String investmentCcy;
    private String counterCcy;
    private boolean buy;
    private double limit;
    private String validUntil;

    public CreateOrderRequestDTO() {
    }

    public String getInvestmentCcy() {
        return investmentCcy;
    }

    public void setInvestmentCcy(String investmentCcy) {
        this.investmentCcy = investmentCcy;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public String getCounterCcy() {
        return counterCcy;
    }

    public void setCounterCcy(String counterCcy) {
        this.counterCcy = counterCcy;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

}

