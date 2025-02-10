import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private transient int id; // transient - ignore this field


    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }
}
