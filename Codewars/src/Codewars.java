import java.util.Arrays;
public class Codewars {
    public static String oddOrEven(int[] array) {
        System.out.println(Arrays.toString(array));
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println("The sum is: " + sum);
        if (sum % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }
}