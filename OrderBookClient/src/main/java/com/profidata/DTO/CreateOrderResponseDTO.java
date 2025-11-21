package com.profidata.DTO;

public class CreateOrderResponseDTO {
    private String investmentCcy;
    private String counterCcy;
    private boolean buy;
    private double limit;
    private String validUntil;
    private String id;

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

