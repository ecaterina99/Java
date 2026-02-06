class Student {
    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int gpa;
    int age;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", age=" + age +
                ", name='" + name +
                '}';
    }

    public Student(String name, int age, int gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    static char getLastNameFirstLetter(Student s) {
        String full = s.getName().trim();
        String[] parts = full.split(" ");

        String lastName = parts[parts.length - 1];

        return lastName.charAt(0);
    }

}