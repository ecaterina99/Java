import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithms {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        int temp;
        for (int j = 0; j < digits.length - 1; j++) {
            for (int i = 0; i < digits.length - 1; i++) {
                if (digits[i] < digits[i + 1]) {
                    temp = digits[i];
                    digits[i] = digits[i + 1];
                    digits[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(digits));


        int[] digits2 = {3, 1, 7, 9, 9, 5};
        StringBuilder result = new StringBuilder();
        Arrays.sort(digits2);
        for (int j = digits2.length - 1; j >= 0; j--) {
            result.append(digits2[j]);
        }
        System.out.println(result);

        int[] digits3 = {3, 1, 7, 9, 9, 5};
        System.out.println(Arrays.toString(Arrays.stream(digits3).boxed().sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new)));
    }
}