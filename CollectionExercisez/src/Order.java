public class Order {

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

    public Order(int quantity, String product) {
        this.quantity = quantity;
        this.product = product;
    }

    String product;
        int quantity;
    }

