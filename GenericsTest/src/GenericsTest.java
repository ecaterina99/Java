import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
//Before Java 5//

        List animals = new ArrayList();
        Animal ourAnimal = new Animal();
//        animals.add(ourAnimal);  - Exception : Animal cannot be cast to class java.lang.String
        animals.add("cat");
        animals.add("dog");

        String animal = (String) animals.get(0); //downcast
        System.out.println(animal);

        //After Java 5, with generics//
        List<String> animals2 = new ArrayList<String>();
        animals2.add("cat");
        animals2.add("dog");
        animals2.add(ourAnimal.toString());
        String animal2 = animals2.get(1);
        System.out.println(animal2);

        //After Java7//
        List<String> animals3 = new ArrayList<>();
        animals3.add("frog");
        animals3.add("dog");
        String animal3 = animals3.get(0);
        System.out.println(animal3);

    }
}

class Animal {
}

//the difference is that in array list we don't use down casting and can put any type of data