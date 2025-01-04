public class FastFoodRestaurant {
    public static void main(String[] args) {
        Pizza prosciutto = new Pizza("Prosciutto", 15);
        prosciutto.addSpice("tomato");
        prosciutto.addSpice("sour cream");
        Sandwich fungi = new Sandwich("Fungi", 12);
        fungi.addSpice("cucumber");
        fungi.addSpice("onion");
        fungi.addSpice("tomato");

        System.out.println(prosciutto);
        System.out.println(fungi);
    }
}
