import java.io.*;

public class WriteObject {
    public static void main(String[] args) {
        Person person1 = new Person("Bob", 1);
        Person person2 = new Person("John", 2);
        Person[] people = {new Person("Jane", 3), new Person("Ana", 4), new Person("Kate", 5)};
        Person[] workers = {new Person("Maria", 7), new Person("Ion", 8)};
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/people.bin"))) {

            //Write 2 persons
            oos.writeObject(person1);
            oos.writeObject(person2);

            //Write array 'people'
            oos.writeInt(people.length);
            for (Person p : people) {
                oos.writeObject(p);
            }

            //Write array 'workers'
            oos.writeObject(workers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}