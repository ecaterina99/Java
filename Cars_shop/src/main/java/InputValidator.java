import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public FilterCriteria getFilterCriteria(int choice) throws IllegalArgumentException {
        FilterCriteria criteria = new FilterCriteria();

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter manufacturer name: ");
                    String manufacturer = scanner.nextLine().trim();
                    if (manufacturer.isEmpty()) {
                        throw new IllegalArgumentException("Manufacturer name cannot be empty");
                    }
                    criteria.setManufacturer(manufacturer);
                    break;

                case 2:
                    System.out.print("Enter minimum production year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    if (year < 1900 || year > 2025) {
                        throw new IllegalArgumentException("Invalid year range");
                    }
                    criteria.setMinYear(year);
                    break;

                case 3:
                    System.out.print("Enter consumption type (ELECTRIC, FUEL, HYBRID): ");
                    String consumptionInput = scanner.nextLine().trim().toUpperCase();

                    try {
                        Car.Consumption consumption = Car.Consumption.valueOf(consumptionInput);
                        criteria.setConsumption(consumption);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Invalid consumption type");
                    }

                    if (criteria.getConsumption() == Car.Consumption.FUEL ||
                            criteria.getConsumption() == Car.Consumption.HYBRID) {
                        System.out.print("Enter minimum consumption value: ");
                        int minConsumption = scanner.nextInt();
                        System.out.print("Enter maximum consumption value: ");
                        int maxConsumption = scanner.nextInt();
                        scanner.nextLine();

                        if (minConsumption < 0 || maxConsumption < 0 || minConsumption > maxConsumption) {
                            throw new IllegalArgumentException("Invalid consumption range");
                        }

                        criteria.setMinConsumption(minConsumption);
                        criteria.setMaxConsumption(maxConsumption);
                        criteria.setCheckConsumptionRange(true);
                    }
                    break;

                case 4:
                    System.out.println("Showing all cars:");
                    break;

                default:
                    throw new IllegalArgumentException("Invalid choice");
            }

            return criteria;

        } catch (IllegalArgumentException e) {
            scanner.nextLine();
            throw new IllegalArgumentException("Invalid input: " + e.getMessage());
        }
    }

}
