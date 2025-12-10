package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Response object returned by the backend after an order is created
 * or after retrieving existing orders.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponseDTO {
    private String id;
    private String investmentCcy;
    private String counterCcy;
    private boolean buy;
    private double limit;
    private String validUntil;
}
