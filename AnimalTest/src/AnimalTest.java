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

        test(animal);
        test(cat);
        test(rex);
    }
    public static void test(Animal animal) {
        animal.eat();
    }
}
