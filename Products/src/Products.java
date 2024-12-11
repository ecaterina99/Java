public class Products {

    public static void main(String[] args) {
        Product milk = new Product("Milk", 4.50, 5);
        milk.displayInfo();
        milk.sellProduct();

        Product cheese = new Product("Cheese", 8.90, 0);
        cheese.displayInfo();
        cheese.sellProduct();
        cheese.addStock();
    }
}

class Product {
    String name;
    double price;
    int stock;


    Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void displayInfo() {
        System.out.println("The product: " + name + ", price:" + price + ", stock:" + stock);
    }

    public void sellProduct() {
        if (stock > 0) {
            this.stock--;
            System.out.println("The product has been sold. Remaining stock: " + this.stock);
        } else {
            System.out.println("The product is out of stock");
        }
    }

    public void addStock() {
        this.stock++;
        System.out.println("A product is added to stock. Current stock: " + this.stock);
    }
}