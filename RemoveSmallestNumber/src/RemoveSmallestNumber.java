/*
Given an array of integers, remove the smallest value. Do not mutate the original array/list.
If there are multiple elements with the same value, remove the one with the lowest index.
If you get an empty array, return an empty array. Don't change the order of the elements that are left.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveSmallestNumber {
    public static void main(String[] args) {

        int[] input = {2, 3, 4, 1, 8, 5};

        if (input.length == 0) {
          System.out.println("Array is empty");
        }

        List<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            inputList.add(input[i]);
        }

        Integer minValue = Collections.min(inputList);
        System.out.println(minValue);
        inputList.remove(minValue);
        System.out.println(inputList);

    }
}