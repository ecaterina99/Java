import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FilterManager app = new FilterManager(new InputValidator(scanner));

    public static void main(String[] args) {
        System.out.println("Welcome to Car Filter Application!");

        boolean exit = false;
        while (!exit) {
            try {
                displayMainMenu();
                int choice = getUserChoice();

                if (choice == 5) {
                    exit = true;
                    System.out.println("Application terminated successfully.");
                    continue;
                }

                if (choice >= 1 && choice <= 4) {
                    app.processFilter(choice);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Input error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n=== Select Filter By ===");
        System.out.println("1. Manufacturer");
        System.out.println("2. Production Year");
        System.out.println("3. Consumption Type");
        System.out.println("4. All Cars");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() throws IllegalArgumentException {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (Exception e) {
            scanner.nextLine();
            throw new IllegalArgumentException("Please enter a valid number");
        }
    }
}