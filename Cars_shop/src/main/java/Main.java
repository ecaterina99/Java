import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.Scanner;


public class Main {

    enum Consumption {ELECTRIC, FUEL, HYBRID}

        public static void displayMainMenu() {
            System.out.println("===select filter by:===");
            System.out.println("1.manufacturer");
            System.out.println("2.production-year");
            System.out.println("3.consumption");
            System.out.println("4.all cars");
            System.out.println("5.exit");
        }


        public static void main(String[] args) throws IOException, XMLStreamException {


        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            int filter;
            Scanner scanner = new Scanner(System.in);
            filter = scanner.nextInt();
            scanner.nextLine();

            String manufacturerFilter = null;
            int yearFilter = 0;
            Consumption consumptionFilter = null;

            switch (filter) {
                case 1:
                    System.out.println("Please, enter the manufacturer");
                    manufacturerFilter = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Please, enter production-year");
                    yearFilter = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Please, enter consumption type: ELECTRIC, FUEL, HYBRID");
                    consumptionFilter = Consumption.valueOf(scanner.nextLine().toUpperCase());

                    break;
                case 4:
                    System.out.println("Showing all cars.");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Application terminated successfully");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();

            Reader reader = new FileReader("cars.xml");

            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);

            String carId = null;
            String manufacturer = null, model = null, production_year = null;
            double horsepower = 0.0, price = 0.0, consumptionValue = 0.0;
            Consumption consumption = null;
            String currentElement = null;

            while (xmlStreamReader.hasNext()) {
                switch (xmlStreamReader.next()) {

                    case XMLStreamReader.START_ELEMENT:
                        currentElement = xmlStreamReader.getName().toString();
                        if ("car".equals(currentElement)) {
                            carId = xmlStreamReader.getAttributeValue(null, "id");
                            manufacturer = model = production_year = null;
                            horsepower = price = 0.0;

                        } else if ("consumption".equals(currentElement)) {
                            String type = xmlStreamReader.getAttributeValue(null, "type");
                            if (type != null) {
                                try {
                                    consumption = Consumption.valueOf(type.toUpperCase());
                                } catch (IllegalArgumentException e) {
                                    consumption = null;
                                }
                            }
                        }
                        break;

                    case XMLStreamReader.CHARACTERS:
                        if (currentElement != null) {

                            String text = xmlStreamReader.getText().trim();
                            if (!text.isEmpty()) {
                                switch (currentElement) {
                                    case "manufacturer":
                                        manufacturer = text;
                                        break;
                                    case "model":
                                        model = text;
                                        break;
                                    case "production-year":
                                        production_year = text;
                                        break;
                                    case "horsepower":
                                        try {
                                            horsepower = Double.parseDouble(text);
                                        } catch (NumberFormatException e) {
                                            horsepower = 0.0;
                                        }
                                        break;

                                    case "consumption":
                                        try {
                                            consumptionValue = Double.parseDouble(text);
                                        } catch (NumberFormatException e) {
                                            consumptionValue = 0.0;
                                        }

                                    case "price":
                                        try {
                                            price = Double.parseDouble(text);
                                        } catch (NumberFormatException e) {
                                            price = 0.0;
                                        }
                                        break;
                                }
                            }
                        }
                        break;

                    case XMLStreamReader.END_ELEMENT:
                        String endElementName = xmlStreamReader.getLocalName();

                        if ("car".equals(endElementName)) {
                            boolean filtered = false;
                            if (filter == 1 && manufacturer != null && manufacturer.equalsIgnoreCase(manufacturerFilter)) {
                                filtered = true;
                            } else if (filter == 2) {
                                int year = Integer.parseInt(production_year);
                                if (year >= yearFilter) {
                                    filtered = true;
                                }
                            } else if (filter == 3 && consumption != null && consumption.equals(consumptionFilter)) {
                                if (consumptionFilter == Consumption.FUEL || consumptionFilter == Consumption.HYBRID) {
                                    System.out.println("Please, enter the minimal consumption");
                                    int min = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Please, enter the maximal consumption");
                                    int max = scanner.nextInt();
                                    scanner.nextLine();
                                    if(consumptionValue>min && consumptionValue<max) {
                                        filtered = true;
                                    }
                                }
                                else if (consumptionFilter == Consumption.ELECTRIC) {
                                    filtered = true;
                                }
                                else{
                                    System.out.println("invalid consumption type");
                                }
                            }
                            if (filtered) {
                                System.out.println("=== car ===");
                                System.out.println("id: " + carId);
                                System.out.println("  manufacturer: " + (manufacturer != null ? manufacturer : "Not available"));
                                System.out.println("  model: " + (model != null ? model : "Not available"));
                                System.out.println("  production-year: " + production_year);
                                System.out.println("  horsepower: " + (horsepower != 0 ? horsepower : "Not available"));
                                System.out.println("  consumption: " + (consumption != null ? consumption : "Not available"));
                                System.out.println("  consumption value: " + consumptionValue);
                                System.out.println("  Price: " + price);
                                System.out.println();
                            }
                        }
                        currentElement = null;
                        break;
                }
            }
            xmlStreamReader.close();
            reader.close();
        }

        }

}

