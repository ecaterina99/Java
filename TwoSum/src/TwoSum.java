/*Write a function that takes an array of numbers (integers for the tests) and a target number.
It should find two different items in the array that, when added together, give the target value.
The indices of these items should then be returned in a tuple / list;
The input will always be valid (numbers will be an array of length 2 or greater,
and all of the items will be numbers; target will always be the sum of two different items from that array).
Example:
two_sum([1, 2, 3], 4) == {0, 2}
two_sum([3, 2, 4], 6) == {1, 2}
 */

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 8};
        int target = 10;
        int[] result = new int[2];


        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    System.out.println(Arrays.toString(result));
                }
            }
        }
    }
}