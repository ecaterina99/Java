public class This {

    public static void main(String[] args) {
        Human h = new Human( "John", "123 Main St", -1);
        h.getInfo();

        Human h1 = new Human();
        h1.name =   "Bob";
        h1.address = "113 Main St";
        h1.setAge(22);
        h1.calculateIq();
        h1.getInfo();
    }

}

class Human {
    public String name;
    public String address;
    private int age;
    private int iq;

    Human(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.setAge(age);
        this.calculateIq();
    }

    Human() {
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            System.out.println("Invalid Age");
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void calculateIq() {
        if(age > 0){
            this.iq = age * 2;
        } else {
            this.iq = 0;
        }
    }


    public void getInfo() {
        System.out.println("Hi my name is " + name + " I am " + age + " years old and I am living on " + address + " and my iq is: " + iq);
    }

}

