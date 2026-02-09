class Student {
    String name;
    int age;
    double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
}