public class ClassesAndObjects {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setNameAndAge("David", 22);
        person1.speak();
        int years1 = person1.calculateYearsToRetirement();
        System.out.println("Years to retirement: " + years1);

        Person person2 = new Person();
        person2.setNameAndAge("Bob", 40);
        person2.speak();
        int years2 = person2.calculateYearsToRetirement();
        System.out.println("Years to retirement: " + years2);
    }
}

class Person {
    String name;
    int age;

    void setNameAndAge(String username, int userage) {
        System.out.println("Hello!");
        name = username;
        age = userage;

    }

    void speak()
    {
        System.out.println("My name is " + name + ", " + "I'm " + age);
    }

    int calculateYearsToRetirement() {
        int years = 65 - age;
        return years;
    }
}