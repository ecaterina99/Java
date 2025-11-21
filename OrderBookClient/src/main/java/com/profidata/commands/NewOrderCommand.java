package com.profidata.commands;

import com.profidata.DTO.CreateOrderRequestDTO;
import com.profidata.DTO.CreateOrderResponseDTO;
import com.profidata.DTO.CurrencyPairDTO;
import com.profidata.service.CurrencyPairService;
import com.profidata.service.OrderService;
import com.profidata.util.CurrencyUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

public class NewOrderCommand implements Command {
    private final OrderService orderService;
    private final CurrencyPairService currencyPairService;

    public NewOrderCommand(OrderService orderService, CurrencyPairService currencyPairService) {
        this.orderService = orderService;
        this.currencyPairService = currencyPairService;
    }

    @Override
    public boolean supports(String input) {
        return input.trim().toLowerCase().startsWith("new buy") || input.trim().toLowerCase().startsWith("new sell");
    }

    @Override
    public void execute(String input) throws Exception {
        boolean isValidRequest = this.validate(input);

        if (isValidRequest) {

            String[] parts = input.split("\\s+");

            String side = parts[1];
            CreateOrderRequestDTO createOrderRequestDTO = getCreateOrderRequestDTO(parts, side);

            CreateOrderResponseDTO response = orderService.createOrder(createOrderRequestDTO);

            System.out.println("Created order with id: " + response.getId());
        }

    }

    private static CreateOrderRequestDTO getCreateOrderRequestDTO(String[] parts, String side) {
        String investment = parts[2];
        String counter = parts[3];
        double limit = Double.parseDouble(parts[4]);
        String validUntil = parts[5];

        CreateOrderRequestDTO createOrderRequestDTO = new CreateOrderRequestDTO();
        createOrderRequestDTO.setBuy(side.equalsIgnoreCase("buy"));
        createOrderRequestDTO.setInvestmentCcy(investment);
        createOrderRequestDTO.setCounterCcy(counter);
        createOrderRequestDTO.setLimit(limit);
        createOrderRequestDTO.setValidUntil(validUntil);
        return createOrderRequestDTO;
    }

    public boolean validate(String input) throws Exception {
        String[] parts = input.trim().split("\\s+");

        if (parts.length != 6) {
            System.out.println("Invalid format. Expected: new [buy|sell] <invCcy> <ctrCcy> <limit> <dd.MM.yyyy>");
            return false;
        }

        List<CurrencyPairDTO> pairs = currencyPairService.getSupportedCurrencyPair();
        Set<String> supportedPairs = CurrencyUtils.extractSupportedPairs(pairs);
        String investment = parts[2];
        String counter = parts[3];
        String limitStr = parts[4];
        String validUntil = parts[5];
        String pair = investment + " " + counter;


        if (!supportedPairs.contains(pair)) {
            System.out.println("Unsupported currency pair: " + pair);
            System.out.println("Supported currency pairs: " + supportedPairs);
            return false;
        }

        try {
            Double.parseDouble(limitStr);
        } catch (NumberFormatException e) {
            System.out.println("Limit must be a valid number (e.g., 1.14).");
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate.parse(validUntil, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Validity must be a valid date in dd.MM.yyyy format.");
            return false;
        }

        return true;
    }
}
