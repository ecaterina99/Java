public class ComparingObjects {

    public static void main(String[] args) {

        //animal 1 -> {1}
        //animal 2 -> {1}

        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(1);
//        System.out.println(animal1==animal2); - false

        System.out.println("Animal 1 id is equal to animal 2 id ? " + animal1.equals(animal2));

        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println("Str 1 = Str 2 ? " + str1 == str2);    // false (comparație între referințe)
        System.out.println("Str 1 = Str 2 ? " + str1.equals(str2)); // true (egalitate logică)
    }
}

class Animal {
    private int id;

    public Animal(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) { //'equals(Object obj)' - original method  {
        Animal otherAnimal = (Animal) obj; //down casting obj in Animal
        return this.id == otherAnimal.id;
    }
}
