package com.example.cli;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
/**
 * Console application entry point. Displays usage instructions,
 * accepts user input and delegates processing to CommandProcessor.
 */
@Component
@RequiredArgsConstructor
public class ConsoleRunner implements CommandLineRunner {

    /** Central command dispatcher. */
    private final CommandProcessor processor;

    @Override
    public void run(String[] args) throws Exception {

        System.out.println("Supported commands:");
        System.out.println("Create new order: new [buy|sell] <investment ccy> <counter ccy> <limit> <validity>");
        System.out.println("Cancel the order: cancel <ID>");
        System.out.println("Print all rates: rates");
        System.out.println("Print all orders: orders");
        System.out.println("Print summary: summary");
        System.out.println("Type 'exit' to quit.");

        Scanner scanner = new Scanner(System.in);

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