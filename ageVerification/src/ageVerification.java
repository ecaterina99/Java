public class ageVerification {
    public static void main(String[] args) {
        System.out.printf("Please, enter your age");
        int age;
        String message = (age < 18) ? "You can’t enter" : "Welcome";
        System.out.println(message);
    }
}
