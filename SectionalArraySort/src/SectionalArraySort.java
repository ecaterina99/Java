/*
In this kata you are given an array to sort but you're expected to start sorting from a specific position of
the array (in ascending order) and optionally you're given the number of items to sort.

Inputs:
An array to sort
The starting index for sorting
(Optional) The number of items to sort
If the number of items to sort is not provided or is zero,
sort the array from the starting position to the end.

Examples:
array: [1, 2, 5, 7, 4, 6, 3, 9, 8]
start: 2
length: not specified
expected result: [1, 2, 3, 4, 5, 6, 7, 8, 9]

array: [9, 7, 4, 2, 5, 3, 1, 8, 6]
start: 2
length: 5
expected result: [9, 7, 1, 2, 3, 4, 5, 8, 6]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SectionalArraySort {
    public static void main(String[] args) {
        int[] array = {9, 7, 4, 2, 5, 3, 1, 8, 6};
        int start = 2;
        int lengthValue = 4;

        int[] result = new int[array.length];
        ArrayList<Integer> afterStart = new ArrayList<>();
        ArrayList<Integer> finalArr = new ArrayList<>();

        if (lengthValue <= 0) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = 0; i < start; i++) {
                finalArr.add(array[i]);
            }
            for (int i = start; i < Math.min(start + lengthValue, array.length); i++) {
                afterStart.add(array[i]);
            }

            Collections.sort(afterStart);
            for (int i = 0; i < afterStart.size(); i++) {
                finalArr.add(afterStart.get(i));
            }

            ArrayList<Integer> endArray = new ArrayList<>();
            for (int i = Math.min(start + lengthValue, array.length); i < array.length; i++) {
                endArray.add(array[i]);
            }
            for (int i = 0; i < endArray.size(); i++) {
                finalArr.add(endArray.get(i));
            }

            result = finalArr.stream().mapToInt(Integer::intValue).toArray();
            System.out.println(Arrays.toString(result));
        }
    }

}