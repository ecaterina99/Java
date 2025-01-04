public class AbstractClassesTest {
    public static void main(String[] args) {
        Storable product1 = new Gamepad("Logitech", "F710", 129.99, true);
        Printer product2 = new Printer("HP", "Envy Photo 7155", 179.99, true);
        Monitor product3 = new Monitor("Dell", "U2419H", 219.99, 24);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

    }
}
