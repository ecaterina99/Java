package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Data Transfer Object representing a request to create a new FX order.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDTO {
    private String investmentCcy;
    private String counterCcy;
    private boolean buy;
    private double limit;
    private String validUntil;
    private String id;
}
