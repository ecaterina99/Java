public class FilterCriteria {
    private String manufacturer;
    private int minYear;
    private Car.Consumption consumption;
    private int minConsumption;
    private int maxConsumption;
    private boolean checkConsumptionRange;

    public FilterCriteria() {
        this.manufacturer = null;
        this.minYear = 0;
        this.consumption = null;
        this.minConsumption = 0;
        this.maxConsumption = 0;
        this.checkConsumptionRange = false;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getMinYear() {
        return minYear;
    }

    public Car.Consumption getConsumption() {
        return consumption;
    }

    public int getMinConsumption() {
        return minConsumption;
    }

    public int getMaxConsumption() {
        return maxConsumption;
    }

    public boolean isCheckConsumptionRange() {
        return checkConsumptionRange;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    public void setConsumption(Car.Consumption consumption) {
        this.consumption = consumption;
    }

    public void setMinConsumption(int minConsumption) {
        this.minConsumption = minConsumption;
    }

    public void setMaxConsumption(int maxConsumption) {
        this.maxConsumption = maxConsumption;
    }

    public void setCheckConsumptionRange(boolean checkConsumptionRange) {
        this.checkConsumptionRange = checkConsumptionRange;
    }
}