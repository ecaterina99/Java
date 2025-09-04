//ven a two-dimensional array of integers, return the flattened version of the array
// with all the integers in the sorted (ascending) order.

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = {{8, 2, 1}, {100, 5}, {}, {7, 8, 9}};
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                list.add(anInt);
            }
        }
        Collections.sort(list);
        int[] res = list.stream().mapToInt(i -> i).toArray();
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}