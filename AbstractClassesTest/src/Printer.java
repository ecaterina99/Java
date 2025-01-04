public class Printer extends Product {

    boolean color;


    public Printer(String brand, String model, double price, boolean color) {
        super(brand, model, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "color=" + color;
    }

    @Override
    public int checkStock() {
        return (int) (Math.random() * 100);
    }
}