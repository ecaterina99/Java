import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.println("Which operation do you want to perform?");
        op = sc.nextLine();

        int x;
        int y;
        System.out.println("Enter the x coordinate");
        x = sc.nextInt();
        System.out.println("Enter the y coordinate");
        y = sc.nextInt();
        float result;
        boolean calculated=true;

        if (op.equals("+")) {
            result = x + y;

        }
        else if (op.equals(" -")) {
            result = x - y;

        }
        else if (op.equals("*")) {
            result = x * y;

        }
        else if (op.equals("/")) {
            result = (float) x / y;

        }
        else {
            result = -1;
            calculated=false;
        }
        System.out.println("The result is:" + (!calculated ? "Invalid operation" : result));
    }
}
