public class Monitor extends Product {
    double diagonal;

    public Monitor(String brand, String model, double price, double diagonal) {
        super(brand, model, price);
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "diagonal = " + diagonal;
    }

    @Override
    public int checkStock() {
        return (int) (Math.random() * 100);
    }
}