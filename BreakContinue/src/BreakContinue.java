public class BreakContinue {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if (i == 8) {
                break;
            }
            System.out.println(i);
            i++;
        }

        System.out.println("Odd numbers: ");
        for (int j = 0; j < 8; j++) {
            if (j % 2 == 0) {
                continue;
            }
            System.out.println(j);
        }
        System.out.println("The program has successfully completed.");
    }
}
