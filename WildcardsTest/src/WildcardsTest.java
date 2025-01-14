import java.util.ArrayList;
import java.util.List;

public class WildcardsTest {
    public static void main(String[] args) {
        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        test(listOfAnimal);
        test(listOfDogs);

    }
 /*  private static void test(List <? super Animal> list) { super --all classes parents (Object)
   Hierarchic:
    1)Object
    2)Animal
    3)Dog
     */

    private static void test(List<? extends Animal> list) {  //extends - all classes children (Dog)
        for (Animal animal : list) {
            System.out.println(animal);
            animal.eat();
        }
    }
}
