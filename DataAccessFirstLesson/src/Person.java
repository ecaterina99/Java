public class Person {

    private String name;
    private int age;


    private int id;


    public void setId(int id) {
        this.id = id;
    }

    public int getId(int i) {
        return id;
    }


    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }


    public Person() {
    }

    @Override
    public String toString() {
        return getName() + "\n" + getAge() ;
    }
}
