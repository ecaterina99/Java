package com.example.orderBook;

import com.example.commands.*;
import com.example.config.Configuration;
import com.example.service.OrderService;
import com.example.service.RateService;

import java.util.List;
import java.util.Scanner;

public class OrderBookApplication {

    public static void main(String[] args) {

        CommandProcessor processor = getCommandProcessor();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Supported commands:");
        System.out.println("Create new order: new [buy|sell] <investment ccy> <counter ccy> <limit> <validity>");
        System.out.println("Cancel the order: cancel <ID>");
        System.out.println("Print all rates: rates");
        System.out.println("Print all orders: orders");
        System.out.println("Print summary: summary");


        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                processor.process(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Bye!");
    }

    private static CommandProcessor getCommandProcessor() {
        Configuration configuration = new Configuration();
        OrderService orderService = new OrderService(configuration);
        RateService rateService = new RateService(configuration);

        return new CommandProcessor(List.of(
                new AllOrdersCommand(orderService, rateService),
                new AllRatesCommand(rateService),
                new NewOrderCommand(orderService, rateService),
                new CancelOrderCommand(orderService),
                new SummaryCommand(orderService)
        ));
    }
}