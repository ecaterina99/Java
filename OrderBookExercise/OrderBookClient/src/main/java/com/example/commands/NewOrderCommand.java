package com.example.commands;

import com.example.dto.CreateOrderRequestDTO;
import com.example.dto.CreateOrderResponseDTO;
import com.example.dto.CurrencyPairDTO;
import com.example.service.OrderService;
import com.example.service.RateService;
//import com.profidata.util.CurrencyUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Command that creates a new buy or sell order.
 *   Expected format:
 *   new [buy|sell] <investment ccy> <counter ccy> <limit> <validity>
 */
public class NewOrderCommand implements Command {
    private final OrderService orderService;
    private final RateService rateService;

    public NewOrderCommand(OrderService orderService, RateService rateService) {
        this.orderService = orderService;
        this.rateService = rateService;
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

            CreateOrderRequestDTO createOrderRequestDTO = getCreateOrderRequestDTO(parts);

            CreateOrderResponseDTO response = orderService.createOrder(createOrderRequestDTO);

            System.out.println("Created order with id: " + response.getId());
        }

    }

    public CreateOrderRequestDTO getCreateOrderRequestDTO(String[] parts) {
        String side = parts[1];
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

        //Maybe also storing currency pairs in some kind of cache will make sense
        List<CurrencyPairDTO> pairs = rateService.getSupportedCurrencyPairs();
      //  Set<String> supportedPairs = CurrencyUtils.extractSupportedPairs(pairs);
        String investment = parts[2];
        String counter = parts[3];
        String limitStr = parts[4];
        String validUntil = parts[5];
        String pair = investment + " " + counter;


        boolean isSupported = pairs.stream()
                .anyMatch(cp -> cp.getCcy1().equalsIgnoreCase(investment)&&
                        cp.getCcy2().equalsIgnoreCase(counter) );


        if (!isSupported) {
            System.out.println("Unsupported currency pair: " + pair);
            System.out.println("Supported currency pairs: ") ;
        for (CurrencyPairDTO cp : pairs){
            System.out.println(cp.getCcy1() + " " + cp.getCcy2());
        }
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
