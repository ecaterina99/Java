import java.util.Scanner;

public class Link {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName = userName();
        System.out.println("Hello, " + userName);
        int userAge = userAge();
        System.out.println("You are " + userAge + " years old.");
        boolean itsGirl = girl(userName);
        System.out.println("Are  a girl or a boy ? " + (itsGirl ? "Girl" : "Boy"));

        String personСategory = ageСategory(userAge);
        System.out.println("You are " + personСategory);

    }

    public static String userName() {

        System.out.println("Enter your name");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int userAge() {

        System.out.println("Enter your age");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static boolean girl(String namePerson) {
        int lengthNume = namePerson.length();
        char lastCharacter = namePerson.charAt(lengthNume - 1);
        if (lastCharacter == 'a') {
            return true;
        } else {
            return false;
        }
    }

    public static String ageСategory(int age) {

        switch (age) {
            case 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12:
                return "Child";
            case 13, 14, 15, 16, 17, 18:
                return "Teenager";
        }
        return "Adult";
    }

}
