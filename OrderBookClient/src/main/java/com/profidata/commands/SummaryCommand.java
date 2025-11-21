package com.profidata.commands;

import com.profidata.DTO.CreateOrderResponseDTO;
import com.profidata.service.OrderService;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummaryCommand implements Command {
    private final OrderService client;

    public SummaryCommand(OrderService client) {
        this.client = client;
    }

    @Override
    public boolean supports(String input) {
        return input.equalsIgnoreCase("summary");
    }

    @Override
    public void execute(String input) throws Exception {
        List<CreateOrderResponseDTO> orders = client.getOrders();

        Map<String, List<CreateOrderResponseDTO>> grouped = orders.stream()
                .collect(Collectors.groupingBy(order ->
                        (order.isBuy() ? "buy" : "sell") + "|" +
                                order.getInvestmentCcy() + "|" +
                                order.getCounterCcy()
                ));

        List<Map.Entry<String, List<CreateOrderResponseDTO>>> list = new ArrayList<>(grouped.entrySet());


        list.sort(Comparator
                .comparing((Map.Entry<String, List<CreateOrderResponseDTO>> e) -> e.getKey().split("\\|")[1])
                .thenComparing(e -> e.getKey().split("\\|")[2])
                .thenComparing(e -> e.getKey().split("\\|")[0])
        );

        for (Map.Entry<String, List<CreateOrderResponseDTO>> entry : list) {
            String[] parts = entry.getKey().split("\\|");
            String side = parts[0];
            String investment = parts[1];
            String counter = parts[2];

            List<CreateOrderResponseDTO> groupedOrders = entry.getValue();

            long count = groupedOrders.size();

            double avgLimit = groupedOrders.stream()
                    .mapToDouble(CreateOrderResponseDTO::getLimit)
                    .average()
                    .orElse(0);

            System.out.printf("%-5s %-5s %-5s %d   %.2f%n",
                    side,
                    investment,
                    counter,
                    count,
                    avgLimit
            );
        }
    }

}