/*Your task is to make a function that can take any non-negative integer as an argument and return it
with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.
 */

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int num = 91034;

        if (num <= 9) {
            System.out.println("The result is: " + num);
        } else {
            String stringNumber = Integer.toString(num);
            Integer[] arr = new Integer[stringNumber.length()];
            while (num > 0) {
                for (int i = 0; i < arr.length; i++) {
                    int remainder = num % 10;
                    num = num / 10;
                    arr[i] = remainder;
                }
            }
            Arrays.sort(arr, Collections.reverseOrder());
            StringBuilder resultString = new StringBuilder();
            for (int number : arr) {
                String currentNumber = Integer.toString(number);
                resultString.append(currentNumber);
            }
            int res = Integer.parseInt(resultString.toString());
            System.out.println("The result is: " + res);
        }
    }
}