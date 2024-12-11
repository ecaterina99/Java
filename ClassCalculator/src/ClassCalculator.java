public class ClassCalculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator(25, 5);
        System.out.println(calc.add());
        System.out.println(calc.subtract());
        System.out.println(calc.multiply());
        System.out.println(calc.divide());
    }
}

class Calculator {
    int number1;
    int number2;

    Calculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    int add() {
        return number1 + number2;
    }

    int subtract() {
        return number1 - number2;
    }

    int multiply() {
        return number1 * number2;
    }

    int divide() {
        return number1 / number2;
    }

}



