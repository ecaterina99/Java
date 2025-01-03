public class Product {
    private String name;
    private static final float TVA = 1.2F;
    private int barcode;
    protected float basePrice;

    public Product(String name, int barcode, float basePrice) {
        this.name = name;
        this.barcode = barcode;
        this.basePrice = basePrice;
    }

    public float calculatePrice() {
        return TVA * basePrice;
    }

    public String getInfo() {
        return "Product Name: " + name + "\n"
                + "Barcode: " + barcode + "\n"
                + "Base Price: " + basePrice;
    }
}
