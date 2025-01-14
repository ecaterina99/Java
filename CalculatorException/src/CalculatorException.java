import java.util.Scanner;

public class CalculatorException {
    public static void main(String[] args) {

        int numberA;
        int numberB;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please, enter number A: ");
            numberA = scanner.nextInt();

            System.out.println("Please, enter number B: ");
            numberB = scanner.nextInt();
        } catch (Exception exc) {
            System.out.println("There is an error");
            return;
        }

        if (numberA > numberB) {
            System.out.println("Number " + numberA + " is greater then " + numberB);
        } else if (numberB > numberA) {
            System.out.println("Number " + numberB + " is greater then " + numberA);
        } else {
            System.out.println("Numbers are equal.");
        }

    }
}
