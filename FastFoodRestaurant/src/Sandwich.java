public class Sandwich extends Product {
    public Sandwich(String name, double price) {
        super(name,price);
    }

    @Override
    public double getPrice() {
        return this.price * 1.15;
    }
}
