public class SetAndGet {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setNameAndAge("David", 22);

        Person person2 = new Person();
        person2.setNameAndAge("Kate", 26);

        Person person3 = new Person();
        person3.setNameAndAge("Bob", -5);
    }
}

class Person {
    String name;
    int age;

    void setNameAndAge(String username, int userage) {
        if (username.isEmpty() || userage < 0) {
            System.out.println("Invalid username or age");
        } else {
            name = username;
            age = userage;
            System.out.println("Hello, my name is " + name + "! " + "I'm " + age + " years old.");
        }
    }
}
