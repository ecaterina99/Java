void main() {

    List<Student> students = new ArrayList<>();
    students.add(new Student("David Goodman", 23, 8));
    students.add(new Student("Mark Rose", 25, 90));
    students.add(new Student("Jane Doe", 22, 90));
    students.add(new Student("Jane Dane", 25, 50));

    List<String> sortedStudents = students.stream()
            .sorted(Comparator.comparing(Student::getGpa, Comparator.reverseOrder()).thenComparing(Student::getLastNameFirstLetter).thenComparing(Student::getAge)).map(Student::getName).toList();

    String res = String.join(", ", sortedStudents);

    System.out.println(res);
}
