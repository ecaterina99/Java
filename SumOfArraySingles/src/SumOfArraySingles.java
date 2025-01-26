import java.util.*;

public class SumOfArraySingles {
    public static void main(String[] args) {

        int[] arr = {9, 10, 19, 14, 13, 19, 13};


        List<Integer> withoutDuplicates = new ArrayList<Integer>();
        for (int n : arr) {
            withoutDuplicates.add(n);
        }


        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer number : withoutDuplicates) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        List<Integer> elementsToRemove = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                elementsToRemove.add(entry.getKey());
            }
        }

        withoutDuplicates.removeAll(elementsToRemove);


        int[] finalArray = withoutDuplicates.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.print(Arrays.toString(finalArray));
        System.out.println("\n");

        int sum = 0;
        for (int i = 0; i < finalArray.length; i++) {
            sum += finalArray[i];
        }
        System.out.println("The sum is: " + sum);

    }
}

/*
        for (int i = 0; i < withoutDuplicates.size()-1; i++) {
            for (int j = i+1; j < withoutDuplicates.size(); j++) {
                if (Objects.equals(withoutDuplicates.get(i), withoutDuplicates.get(j))) {
                    elementToRemove1 = withoutDuplicates.remove(i);
                    tempElementToRemove2 = withoutDuplicates.remove(j);
                    while (withoutDuplicates.contains(elementToRemove1)) {
                        withoutDuplicates.remove(i);
                    }
                }
            }
        }
*/
        /*
        withoutDuplicates = new ArrayList<>(new HashSet<>(withoutDuplicates));
        System.out.println(withoutDuplicates);
*/