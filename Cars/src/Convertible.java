
public class Convertible extends Car {

    String roofType;

    public Convertible(String make, String model, int weight, String color, String roofType) {
        super(make, model, weight, color);
        this.roofType = roofType;

    }

    @Override
    String getInfo() {
        return super.getInfo() + "\n" +
                "roof type: " + this.roofType;
    }
}