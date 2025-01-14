public class AnimalTest {
    public static void main(String[] args) {
        Dog rex = new Dog();
        rex.showName();
        rex.sleep();
        rex.play();
        rex.eat();
        rex.bark();

        Animal animal = new Animal();
        Cat cat = new Cat();
        Animal animal2 = new Dog(); // Upcasting - Este conversia unui obiect al unei clase copil la tipul clasei părinte.
        animal2.eat();

//         Downcasting - Este conversia unui obiect al clasei părinte la tipul clasei copil. Necesită specificarea explicită a tipului.
        Dog dog2 = (Dog) animal2;
        dog2.sleep();


        animal.sleep();
        test(animal);
        test(cat);
        test(rex);
        test(animal2);
        test(dog2);
    }

    public static void test(Animal animal) {
        animal.eat();
    }
}
