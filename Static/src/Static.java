public class Static {
    public static void main(String[] args) {
        Human h1 = new Human("Bob", 30);
        Human h2 = new Human("Garry", 50);
        Human h3 = new Human("Daniel", 19);
        h1.getInfo();
        h2.getInfo();
        h3.getInfo();
        Human.description = "Nice people";
        Human.getDescription();
        Human.displayNumberOfPeople();

    }
}

class Human {
    private String name;
    private int age;

    public static String description;
    public static int countPeople;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        countPeople++;
    }

    public void getInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void getDescription() {
        System.out.println(description);
    }

    public static void displayNumberOfPeople() {
        System.out.println("Number of people is: " + countPeople);
    }
}
