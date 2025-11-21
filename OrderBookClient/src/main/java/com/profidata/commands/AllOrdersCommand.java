package com.profidata.commands;

import com.profidata.DTO.CreateOrderResponseDTO;
import com.profidata.DTO.FXRateDTO;
import com.profidata.service.OrderService;
import com.profidata.service.RateService;
import com.profidata.util.FXCalculator;

import java.util.Comparator;
import java.util.List;

public class AllOrdersCommand implements Command {

    private final OrderService client;
    private final RateService rateService;


    public AllOrdersCommand(OrderService client, RateService rateService) {
        this.client = client;
        this.rateService = rateService;
    }

    @Override
    public boolean supports(String input) {
        return input.equalsIgnoreCase("orders");
    }

    @Override
    public void execute(String input) throws Exception {
        List<CreateOrderResponseDTO> orders = client.getOrders();
        List<FXRateDTO> rates = rateService.getRates();


        orders.sort(Comparator.comparing(CreateOrderResponseDTO::getCounterCcy)
                .thenComparing(order -> {
                    try {
                        return FXCalculator.calculateDistance(rates, order);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }));

        for (CreateOrderResponseDTO order : orders) {
            double distance = FXCalculator.calculateDistance(rates, order);

            System.out.printf(
                    "%-5s %5s %5s %5s %8s %12s   %.5f\n",
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

