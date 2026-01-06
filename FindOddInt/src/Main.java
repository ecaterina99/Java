/**
 * Given an array of integers, find the one that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] a = {8, 3, 1, 3, 1, 3,8 };
        int odd=0;
        int len = a.length;

        HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        if (len == 1 ) {
            odd = a[0];
        }
        for (int j : a) {
            pairs.put(j, pairs.getOrDefault(j, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> pair : pairs.entrySet()) {
            if(pair.getValue() % 2 == 1) {
                odd = pair.getKey();
            }
        }
        System.out.println("The result is: "+odd);
    }
}