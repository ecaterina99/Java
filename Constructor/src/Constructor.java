public class Constructor {
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human("Bob");
        Human human3 = new Human("Tom", 15);
    }
}

class Human {
    private String name;
    private int age;

    //Constructor 1 default
    public Human() {
        this.name = "Adam";
        this.age = 18;
        System.out.println("constructor 1 " + name + ", " + age);
    }

    public Human(String name) {
        this.name = name;
        System.out.println("constructor 2");
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("constructor 3");
    }

}