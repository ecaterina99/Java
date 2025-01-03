public class MyStore {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 8562, 10);
        System.out.println(milk.getInfo());
        System.out.println("price after TVA: " + milk.calculatePrice());

        Chocolate heidi = new Chocolate("Heidi", 4552, 8, 90);
        System.out.println(heidi.getInfo());
        System.out.println("Price after TVA: " + heidi.calculatePrice());

        Wine avalon = new Wine("Avalon", 4552, 50, 750);
        System.out.println(avalon.getInfo());
        System.out.println("Price after TVA: " + avalon.calculatePrice());
    }
}
