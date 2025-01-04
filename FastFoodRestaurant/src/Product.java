public abstract class Product {

    public String name;
    public double price;
    public String[] spices;

    public abstract double getPrice();

    public Product(String name, double price) {
        this.spices = new String[10];
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Product name: ").append(this.name);
        output.append(", price: ").append(this.price);
        output.append(", spices: ").append(allSpices());

        return output.toString();
    }

    public String allSpices() {
        StringBuilder output = new StringBuilder();

        for (String addition : this.spices) {
            if (addition != null) {
                output.append(addition).append(", ");
            }
        }
        if (!output.toString().isEmpty()) {
            if (output.toString().trim().endsWith(",")) {
                output.replace(output.length() - 2, output.length(), "");
            }
        } else {
            output.append("No spices");
        }
        return output.toString();
    }

    public void addSpice(String spice) {
        for (int i = 0; i < this.spices.length; i++) {
            if (this.spices[i] == null) {
                this.spices[i] = spice;
                break;
            }
        }
    }

}