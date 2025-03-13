
/*
Numbers with no identical numbers preceding or following it returns a 1:  2, 4, 9  => 1, 1, 1
Sequential groups of identical numbers return their count: 6, 6, 6, 6 => 4
Your function should then repeat the process on the resulting array, and on the resulting array of that,
until it returns a single integer:
[0, 4, 6, 8, 8, 8, 5, 5, 7] =>  [1, 1, 1, 3, 2, 1] => [3, 1, 1, 1] => [1, 3] => [1, 1] => [2]
When your function has reduced the array to a single integer following these rules, it should return that integer.
 */

import java.util.ArrayList;

public class SetReducerRecursion {
    public static void main(String[] args) {
        int[] input = {2, 4, 4, 6, 2, 1, 1, 5, 6, 7, 8, 8, 8, 8, 9, 0, 1, 1, 5, 4, 4};
        int result = setReducer(input);
        System.out.println("Result: " + result);
    }

    public static int setReducer(int[] input) {
        if (input.length == 1) {
            return input[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        for (int i = 0; i < input.length; i++) {
            if (i < input.length - 1 && input[i] == input[i + 1]) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
            }
        }
        System.out.println("Reduced: ");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();

        int[] reduced = list.stream().mapToInt(i -> i).toArray();
        return setReducer(reduced);
    }
}