/*
In this Kata, you will be given an array of numbers in which two numbers occur once and the rest occur only twice. 
Your task will be to return the sum of the numbers that occur only once.
For example, repeats([4,5,7,5,4,8]) = 15 because only the numbers 7 and 8 occur once, and their sum is 15. 
Every other number occurs twice.
 */

import java.util.*;

public class SumOfArraySingles {
    public static void main(String[] args) {

        int[] arr = {9, 10, 19, 14, 13, 19, 13};

        //First Solution
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

        /*Second Solution
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        if (arr[0] != arr[1]) {
            sum += arr[0];
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] != arr[i] && arr[i - 1] != arr[i]) {
                sum += arr[i];
            }
        }

        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            sum += arr[arr.length - 1];
        }

        System.out.println(sum);
    }
}

Third solution
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }
}
 */
