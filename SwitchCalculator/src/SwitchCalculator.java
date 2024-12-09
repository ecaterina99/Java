public class SwitchCalculator {
    public static void main(String[] args) {
        int x = 523134;
        int y = 325423;

        int remainder = x % y;
        switch (remainder) {
            case 0:
                remainder = 0;
                System.out.println("Division without remainder");
                break;
            default:
                if (remainder > 1000) {
                    System.out.println("Remainder over 1000");
                } else {
                    System.out.println("Remainder below 1000");
                }
                break;
        }
    }
}

