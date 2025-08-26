//You will be given an array of numbers. You have to sort the odd numbers in ascending order
// while leaving the even numbers at their original positions.

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        ArrayList<Integer> evenNo = new ArrayList<>();
        ArrayList<Integer> oddNo = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int value : array) {
            if (value % 2 == 0) {
                evenNo.add(value);
            }
            if (value % 2 != 0) {
                oddNo.add(value);
            }
        }

        Collections.sort(oddNo);

        int j = 0;
        for (int k : array) {
            if (k % 2 == 0) {
                res.add(k);
            } else {
                res.add(oddNo.get(j));
                j++;
            }
        }

        int [] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }

    }
}