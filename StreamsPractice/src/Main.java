/**
 * Using streams:
 * 1)
 * Leave only numbers greater than 5
 * Multiply each remaining number by 2
 * Sort them in ascending order
 * Collect result into a new list
 * Expected result (just for checking logic): [12, 14, 16, 20, 30, 40]
 * 2)
 * Convert all words to UPPERCASE
 * Remove duplicates
 * Leave only words with length > 4
 * Join them into one string separated by comma
 * Expected result (STREAM,LAMBDA)
 * 3)
 * Given list of students, using streams:
 * Leave only students with grade ≥ 8.0
 * Calculate average age of those students
 * Return it as double
 * 4)
 * Using streams, create: Map<String, List<Product>>
 * where: key = category
 * value = list of products from that category
 * Bonus: sort products inside each category by price.
 *
 */
void main() {
    List<Integer> numbers = List.of(3, 10, 5, 8, 15, 2, 7, 20);
    numbers.stream().filter(num -> num > 5).map(num -> num * 2).sorted().forEach(System.out::println);

    List<String> words = List.of("java", "stream", "api", "code", "lambda", "java");
    String joined = words.stream().map(s -> s.toUpperCase()).distinct().filter(s -> s.length() > 4).collect(Collectors.joining(","));
    System.out.println(joined);

    List<Student> students = List.of(
            new Student("Anna", 20, 8.5),
            new Student("Bob", 19, 7.2),
            new Student("Clara", 22, 9.1),
            new Student("David", 21, 6.8),
            new Student("Eva", 20, 8.0),
            new Student("Frank", 23, 9.5)
    );

    double avg = students.stream().filter(s -> s.getGrade() >= 8.0).mapToDouble(Student::getAge).average().orElse(0);
    System.out.println(avg);

    List<Product> products = List.of(
            new Product("Bread", "food", 1.5),
            new Product("Laptop", "electronics", 1200),
            new Product("Cheese", "food", 4.2),
            new Product("Phone", "electronics", 800),
            new Product("Java Book", "books", 30),
            new Product("Novel", "books", 15),
            new Product("TV", "electronics", 600),
            new Product("Milk", "food", 2.0)
    );

    Map<String, List<Product>> map = products.stream().collect(Collectors.groupingBy(Product::getCategory));
    map.values().forEach(list -> list.sort(Comparator.comparing(Product::getPrice)));
    System.out.println(map);
}