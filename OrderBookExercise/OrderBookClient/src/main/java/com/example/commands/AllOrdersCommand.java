package com.example.commands;

import com.example.dto.CreateOrderResponseDTO;
import com.example.dto.FXRateDTO;
import com.example.service.OrderService;
import com.example.service.RateService;
import com.example.util.FXCalculator;

import java.util.Comparator;
import java.util.List;
/**
 * Command that prints all existing orders sorted by:
 *  1. Currency pair
 *  2. Distance from the current market rate
 */
public class AllOrdersCommand implements Command {

    private final OrderService orderService;
    private final RateService rateService;


    public AllOrdersCommand(OrderService orderService, RateService rateService) {
        this.orderService = orderService;
        this.rateService = rateService;
    }

    @Override
    public boolean supports(String input) {
        return input.equalsIgnoreCase("orders");
    }

    @Override
    public void execute(String input) throws Exception {
        List<CreateOrderResponseDTO> orders = orderService.getOrders();
        List<FXRateDTO> rates = rateService.getRates();


        orders.sort(
                Comparator.comparing(CreateOrderResponseDTO::getInvestmentCcy)
                        .thenComparing(CreateOrderResponseDTO::getCounterCcy)
                        .thenComparing(order -> {
                            try {
                                return FXCalculator.calculateDistance(rates, order);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
        );

        for (CreateOrderResponseDTO order : orders) {
            double distance = FXCalculator.calculateDistance(rates, order);

            System.out.printf(
                    "%-5s %5s %5s %5s %8s %12s  %.2f\n",
                    "id:" + order.getId(),
                    (order.isBuy() ? "BUY" : "SELL"),
                    order.getInvestmentCcy(),
                    order.getCounterCcy(),
                    order.getLimit(),
                    order.getValidUntil(),
                    distance
            );
        }
    }
}

