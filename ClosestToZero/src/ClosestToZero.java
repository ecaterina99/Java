/*
Simply find the closest value to zero from the list. Notice that there are negatives in the list.
List is always not empty and contains only integers. Return None if it is not possible to define
only one of such values. And of course, we are expecting 0 as closest value to zero.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestToZero {
    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 10};

        boolean found = false;
        int result = 0;

        // if arr contains 0
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                found = true;
            }
        }
        if (found) {
            result = 0;
        }
        //if it doesn't contains 0
        else {
            ArrayList<Integer> pos = new ArrayList<>();
            ArrayList<Integer> neg = new ArrayList<>();
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    neg.add(arr[i]);
                } else if (arr[i] > 0) {
                    pos.add(arr[i]);
                }
            }

            if (pos.size() > 0 && neg.size() > 0) {
                if (pos.get(0) > 0 - (neg.get(neg.size() - 1))) {
                    result = neg.get(neg.size() - 1);
                } else if (pos.get(0) < 0 - (neg.get(neg.size() - 1))) {
                    result = pos.get(0);
                } else {
                    result = 111111111;
                }
            } else if (pos.size() > 0 && neg.size() <= 0) {
                result = pos.get(0);
            } else {
                result = 0 - (neg.get(neg.size() - 1));
            }
        }
        System.out.println(result);

    }
}