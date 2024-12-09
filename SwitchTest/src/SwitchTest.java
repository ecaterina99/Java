import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How old are you? ");
        int age = sc.nextInt();

        String category = getCategory(age);

        switch (category) {
            case "child":
                System.out.println("You are younger than 7 years old");
                break;
            case "teenager":
                System.out.println("You are a teenager");
                break;
            case "adult":
                System.out.println("You are an adult");
                break;
            case "pensioner":
                System.out.println("You are a pensioner");
                break;
            default:
                System.out.println("Invalid age entered");
        }

        sc.close();
    }

    public static String getCategory(int age) {
        if (age >= 1 && age <= 7) {
            return "child";
        } else if (age >= 8 && age <= 18) {
            return "teenager";
        } else if (age >= 19 && age <= 65) {
            return "adult";
        } else if (age > 65) {
            return "pensioner";
        } else {
            return "invalid";
        }
    }
}
