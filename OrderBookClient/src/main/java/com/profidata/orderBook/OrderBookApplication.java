package com.profidata.orderBook;

import com.profidata.commands.*;
import com.profidata.config.Configuration;
import com.profidata.service.CurrencyPairService;
import com.profidata.service.OrderService;
import com.profidata.service.RateService;

import java.util.List;
import java.util.Scanner;

public class OrderBookApplication {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        OrderService client = new OrderService(configuration);
        RateService rateService = new RateService(configuration);
        CurrencyPairService currencyPair = new CurrencyPairService(configuration);

        CommandProcessor processor = new CommandProcessor(List.of(
                new AllOrdersCommand(client, rateService),
                new AllRatesCommand(rateService),
                new NewOrderCommand(client, currencyPair),
                new CancelOrderCommand(client),
                new SummaryCommand(client)
        ));

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
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Bye!");
    }
}