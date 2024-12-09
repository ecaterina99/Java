import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your gender (male/female): ");
        String gender = sc.nextLine();

        System.out.println("Enter your phone number: ");
        String phoneNumber = sc.nextLine();

        if (gender.equals("male")) {
            System.out.println("Hello, Mr. " + name + ".");
        } else if (gender.equals("female")) {
            System.out.println("Hello, Mrs. " + name + ".");
        } else {
            System.out.println("Hello, " + name + ".");
        }

        System.out.println("Contact Information:");
        System.out.println("Age: " + age + " years old");
        System.out.println("Phone number: " + phoneNumber);

        sc.close();
    }
}
