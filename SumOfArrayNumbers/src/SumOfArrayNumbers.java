/*
Sum all the numbers of a given array ( cq. list ), except the highest and the lowest element
( by value, not by index! ).
The highest or lowest element respectively is a single element at each edge,
even if there are more than one with the same value.
 */

import java.util.Arrays;

public class SumOfArrayNumbers {
    public static int sum(int[] numbers) {
        if (numbers == null || numbers.length <= 2) {
            return 0;
        }
        int sum = 0;
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length - 1; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}