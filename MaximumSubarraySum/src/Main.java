
import java.util.ArrayList;

/*
The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers
Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
If the list is made up of only negative numbers, return 0 instead. Your solution should be fast,
it will be tested on very large arrays so slow solutions will time out.
Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = 0;
        int sum = 0;

        ArrayList<Integer> sumList = new ArrayList<>();

        if (arr.length <= 0) {
            result = 0;
        } else {
            for (int j : arr) {
                sum = j + sum;
                if (sum < j) {
                    sum = j;
                }
                sumList.add(sum);
            }
            for (Integer integer : sumList) {
                if (integer > result) {
                    result = integer;
                }
            }
        }
        System.out.println(result);
    }
}