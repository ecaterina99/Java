package com.profidata.commands;

import com.profidata.DTO.CreateOrderResponseDTO;
import com.profidata.service.OrderService;

import java.util.List;

public class CancelOrderCommand implements Command {
    private final OrderService orderService;

    public CancelOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public boolean supports(String input) {
        return input.trim().toLowerCase().startsWith("cancel");
    }

    @Override
    public void execute(String input) throws Exception {
        boolean isValidRequest = this.validate(input);

        if (isValidRequest) {

            String[] parts = input.split("\\s+");
            String orderId = parts[1];

            boolean isDeleted = orderService.deleteOrder(orderId);
            if (isDeleted) {
                System.out.println("Order with ID: " + orderId + " is deleted successfully.");
            } else {
                System.out.println("Failed to delete order.");
            }
        }
    }

    public boolean validate(String input) throws Exception {
        String[] parts = input.trim().split("\\s+");
        if (parts.length != 2) {
            System.out.println("Invalid format. Use: cancel <orderId>");
            return false;
        }

        String orderId;

        try {
            orderId = parts[1];
        } catch (NumberFormatException e) {
            System.out.println("Order ID must be a number.");
            return false;
        }

        List<CreateOrderResponseDTO> createOrderResponseDTOs = orderService.getOrders();
        boolean exists = createOrderResponseDTOs.stream()
                .anyMatch(order -> order.getId().equals(orderId));

        if (!exists) {
            System.out.println("This order does not exist.");
            return false;
        }

        return true;
    }

}