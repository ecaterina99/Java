import java.util.*;

public class Main {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : elements) {
            int count = counts.getOrDefault(num, 0);
            if (count < maxOccurrences) {
                result.add(num);
                counts.put(num, count + 1);
            }
        }

        int[] finalArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalArr[i] = result.get(i);
        }

        return finalArr;
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1, 2, 1, 2, 3};
        int n = 2;

        int[] result = deleteNth(input, n);

        System.out.println(Arrays.toString(result));
    }
}