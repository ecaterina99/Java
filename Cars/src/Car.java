public class Car {

    protected String make;
    protected String model;
    protected int weight;
    protected String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {

        if (weight < 0) {
            this.weight = 0;
        } else if (weight > 3000) {
            this.weight = 3000;
        } else {
            this.weight = weight;
        }
    }

    public static final int nrCarsInTheShowroom = 16;

    public Car() {
    }

    public Car(String make, String model, int weight, String color) {
        this.make = make;
        this.model = model;
        this.weight = weight;
        this.color = color;
    }

    String getInfo() {
        return "Make: " + this.make + "\n" +
                "model: " + this.model + "\n" +
                "weight: " + this.weight + "\n" +
                "color: " + this.color;
    }

}
