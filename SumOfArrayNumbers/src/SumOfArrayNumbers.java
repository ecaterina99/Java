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

    /*
    Create a function that returns the sum of the two lowest positive numbers given an array of minimum
    4 positive integers. No floats or non-positive integers will be passed.
    For Java, those integers will come as double precision (long).
     */

    public static long sumTwoSmallestNumbers(long[] longNumbers) {
        long sum2 = 0;
        Arrays.sort(longNumbers);
        sum2 = longNumbers[0] + longNumbers[1];
        return sum2;
    }
}