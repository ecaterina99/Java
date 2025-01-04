public class CalculatorInterfaceTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setOperand(5, 3);
        System.out.println(calc.add());
        System.out.println(calc.sub());

    }
}
