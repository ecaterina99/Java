/**
 * 1)Check if a number is: positive and less than 100
 * 2)Consumer Example – “Do something with value”
 * 3)Function Example – “Transform value”: Convert price in euros → lei (× 5)
 */
void main() {
    //the RULE how to check
    Predicate<Integer> isValid = n -> n > 0 && n < 100;

    System.out.println(isValid.test(50));
    System.out.println(isValid.test(120));

    //Consumer does ACTION, returns NOTHING, method = .accept()
    Consumer<String> formated = name -> System.out.println("Hello dear " + name + " !");
    formated.accept("Ecaterina");

    //Function = converter, .apply() gives result, input type → output type
    Function<Double, Double> eurToRon = eur -> eur * 5;
    Double result = eurToRon.apply(10.0);
    System.out.println(result);

    Predicate<Integer> isPositive = n -> n > 0;
    Predicate<Integer> isEven = n -> n % 2 == 0;
    Predicate<Integer> isSmall = n -> n < 50;

    Predicate<Integer> isValidNumber =
            isPositive.and(isEven).and(isSmall);

    System.out.println(isValidNumber.test(24));
    System.out.println(isValidNumber.test(-5));
    System.out.println(isValidNumber.test(77));

    checkAndPrint(24, isValidNumber, "Congratulations");
    checkAndPrint(25, isValidNumber, "Congratulations");

    Consumer<String> res = s -> System.out.println("[" + s + "]");
    res.accept("java");
    Consumer<Integer> square = n -> System.out.println(n * n);
    square.accept(5);

    Function<String, Integer> func = n -> n.length();
    System.out.println(func.apply("Ecaterina"));

    Function<String, String> firstUpper = s ->
            s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    System.out.println(firstUpper.apply("ecaterina"));
}

void checkAndPrint(int number, Predicate<Integer> rule, String message) {
    if (rule.test(number)) {
        System.out.println(number + " " + message);
    } else {
        System.out.println("The number must be even,small and positive");
    }
}