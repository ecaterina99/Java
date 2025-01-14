import java.util.Scanner;

public class ExceptionsTest {
    public static void main(String[] args) {
        int numberA;
        int numberB;
        int numberC = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter numberA: ");
        numberA = input.nextInt();

        System.out.println("Enter numberB: ");
        numberB = input.nextInt();
        System.out.println("Enter numberC: ");

        try {
            numberC = numberA / numberB;
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

        System.out.println("The result is:" + numberC);



    }

}
