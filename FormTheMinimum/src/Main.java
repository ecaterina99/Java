//Given a list of digits, return the smallest number that could be formed from these digits,
// using the digits only once (ignore duplicates). Only positive integers in the range of 1 to 9
// will be passed to the function.

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] values = {5, 7, 5, 9, 7};
        int result;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            res.add(values[i]);
        }

        StringBuilder sb = new StringBuilder();

        List<Integer> newList = res.stream().sorted().distinct().toList();
        for (Integer i : newList) {
            sb.append(i);
        }
        result = Integer.parseInt(String.valueOf(sb));
        System.out.println(result);
    }

}