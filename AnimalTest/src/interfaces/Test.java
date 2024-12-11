package interfaces;

public class Test {
    //method 1
    public static void main(String[] args) {
//        Animal animal1 = new Animal(1);
//        Person person1 = new Person("Bob");
//        animal1.showInfo();
//        person1.showInfo();

        //method 2
//        Info info1 = new Animal(1);
//        Info info2 = new Person("Bob");
//        info1.showInfo();
//        info2.showInfo();

        //method 3
        Animal animal1 = new Animal(1);
        Person person1 = new Person("Bob");
        outputInfo(animal1);
        outputInfo(person1);
    }

    public static void outputInfo(Info info) {
        info.showInfo();
    }
}
