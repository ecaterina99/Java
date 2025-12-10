package com.example.commands;


import com.example.dto.CreateOrderResponseDTO;
import com.example.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Command that calculate a summary of the current order book.
 * Shows all orders and sorted by investment ccy, counter currency and buy/sell.
 */
@Component
public class SummaryCommand implements Command {
    private final OrderService orderService;

    public SummaryCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public boolean supports(String input) {
        return input.equalsIgnoreCase("summary");
    }

    @Override
    public void execute(String input) {
        List<CreateOrderResponseDTO> orders = orderService.getOrders();

        Map<String, List<CreateOrderResponseDTO>> grouped = orders.stream()
                .collect(Collectors.groupingBy(order ->
                        (order.isBuy() ? "buy" : "sell") + "|" +
                                order.getInvestmentCcy() + "|" +
                                order.getCounterCcy()
                ));

        List<String> keys = new ArrayList<>(grouped.keySet());

        keys.sort(Comparator
                .comparing((String key) -> key.split("\\|")[1])
                .thenComparing(key -> key.split("\\|")[2])
                .thenComparing(key -> key.split("\\|")[0])
        );


        for (String key : keys) {
            String[] parts = key.split("\\|");

            String side = parts[0];
            String investment = parts[1];
            String counter = parts[2];

            List<CreateOrderResponseDTO> group = grouped.get(key);

            long count = group.size();

            double avgLimit = group.stream()
                    .mapToDouble(CreateOrderResponseDTO::getLimit)
                    .average()
                    .orElse(0);

            System.out.printf("%-5s %-5s %-5s %d   %.2f%n",
                    side, investment, counter, count, avgLimit
            );
        }
    }

}