package com.example.dto;
/**
 * Response object returned by the backend after an order is created
 * or after retrieving existing orders.
 */
public class CreateOrderResponseDTO {
    private String investmentCcy;
    private String counterCcy;
    private boolean buy;
    private double limit;
    private String validUntil;
    private String id;

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public void setCounterCcy(String counterCcy) {
        this.counterCcy = counterCcy;
    }

    public void setInvestmentCcy(String investmentCcy) {
        this.investmentCcy = investmentCcy;
    }

    public CreateOrderResponseDTO() {
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

    public void setId(String id) {
        this.id = id;
    }

}

