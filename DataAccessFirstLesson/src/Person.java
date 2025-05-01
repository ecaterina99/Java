public class Person {

    private String name;
    private int age;
    private String pid;

    public String getName() {       return name;    }
    public int getAge() {       return age; }
    public String getPid() {        return pid; }
    public void setName(String name) {      this.name = name;   }
    public void setAge(int age) {       this.age = age; }
    public void setPid(String pid) {        this.pid = pid; }

    public Person(String name, int age, String pid) {
        this.name = name;
        this.age = age;
        this.pid = pid;
    }

    public Person() {   }

    @Override
    public String toString() {
        return getName() + "\n" + getAge() + "\n" + getPid();
    }
}
