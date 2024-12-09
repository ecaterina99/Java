import java.util.Scanner;

public class ScannerDoWhile {

    public static void main(String[] args) {
        //The loop While
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number 5: ");
        int x = sc.nextInt();
        while (x != 5) {
            System.out.println("Enter number 5: ");
            x = sc.nextInt();
        }
        System.out.println("The program has successfully completed.");


        //The loop Do-While
        Scanner s = new Scanner(System.in);
        int value;
        do {
            System.out.print("Enter number 6: ");
            value = s.nextInt();
        } while (value != 6);
        System.out.println("The program has successfully completed.");
    }
}
