import java.util.ArrayList;
import java.util.List;

/*Your goal in this kata is to implement a difference function, which subtracts one
list from another and returns the result.
It should remove all values from list a, which are present in list b keeping their order.
Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other
Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
*/
public class ListDifference {
    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 2, 1, 3, 2};
        int[] b = new int[]{1, 2};
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int value : a) {
            listA.add(value);
        }
        for (int k : b) {
            listB.add(k);
        }

        listA.removeAll(listB);

        int[] arr = listA.stream().mapToInt(i -> i).toArray();

        for (int j : arr) {
            System.out.println(j);
        }
    }
}
