public class Pizza extends Product {

    public Pizza(String name, double price) {
        super(name, price);
    }

    @Override
    public double getPrice() {
        return this.price * 1.1;
    }
}

