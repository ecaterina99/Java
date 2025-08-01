public class Car {
    private String id;
    private String manufacturer;
    private String model;
    private int productionYear;
    private double horsepower;
    private double price;
    private double consumptionValue;
    private Consumption consumption;

    public enum Consumption {
        ELECTRIC, FUEL, HYBRID
    }

    public Car() {
        reset();
    }

    public void reset() {
        this.id = null;
        this.manufacturer = null;
        this.model = null;
        this.productionYear = 0;
        this.horsepower = 0.0;
        this.price = 0.0;
        this.consumptionValue = 0.0;
        this.consumption = null;
    }

    // Getters
    public String getId() { return id; }
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public int getProductionYear() { return productionYear; }
    public double getHorsepower() { return horsepower; }
    public double getPrice() { return price; }
    public double getConsumptionValue() { return consumptionValue; }
    public Consumption getConsumption() { return consumption; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setModel(String model) { this.model = model; }
    public void setProductionYear(int productionYear) { this.productionYear = productionYear; }
    public void setHorsepower(double horsepower) { this.horsepower = horsepower; }
    public void setPrice(double price) { this.price = price; }
    public void setConsumptionValue(double consumptionValue) { this.consumptionValue = consumptionValue; }
    public void setConsumption(Consumption consumption) { this.consumption = consumption; }

    public void display() {
        System.out.println("=== Car ===");
        System.out.println("ID: " + id);
        System.out.println("  Manufacturer: " + (manufacturer != null ? manufacturer : "Not available"));
        System.out.println("  Model: " + (model != null ? model : "Not available"));
        System.out.println("  Production Year: " + (productionYear != 0 ? productionYear : "Not available"));
        System.out.println("  Horsepower: " + (horsepower != 0 ? horsepower : "Not available"));
        System.out.println("  Consumption Type: " + (consumption != null ? consumption : "Not available"));
        System.out.println("  Consumption Value: " + (consumptionValue != 0 ? consumptionValue : "-"));
        System.out.println("  Price: " + (price != 0 ? price : "Not available"));
        System.out.println();
    }
}