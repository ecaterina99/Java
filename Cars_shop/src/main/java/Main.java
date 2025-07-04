import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;


public class Main {

    enum Consumption {ELECTRIC,FUEL,HYBRID};

    public static void main(String[] args) throws IOException, XMLStreamException {

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
            }break;

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
                        if (production_year.compareTo("2015") > 0) {
                            System.out.println("=== car ===");
                            System.out.println("id: "+carId);
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

