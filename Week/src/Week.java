public class Week {
    public static void main(String[] args) {

        int day = 5;

        switch (day) {
            case 0 -> System.out.println("Monday");
            case 1 -> System.out.println("Tuesday");
            case 2 -> System.out.println("Wednesday");
            case 3 -> System.out.println("Thursday");
            case 4 -> System.out.println("Friday");
            case 5 -> System.out.println("Saturday");
            case 6 -> System.out.println("Sunday");


            default -> System.out.println("unknown day");
        }
    }
}
