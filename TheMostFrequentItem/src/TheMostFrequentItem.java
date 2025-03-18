/*
Complete the function to find the count of the most frequent item of an array.
You can assume that input is an array of integers.
 */


public class TheMostFrequentItem {
    public static void main(String[] args) {
        int[] collection = {1, 2, 3, 1, 3, 5, 1, 3 , 5, 3};
        int maxCount = 0;
        int mostFrequentItem = 0;

        for (int i = 0; i < collection.length; i++) {
            int count = 0;
            for (int j = 0; j < collection.length; j++) {
                if (collection[i] == collection[j]) {
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentItem = collection[i];
                }
            }
        }
        System.out.println("The most frequent number is: " + mostFrequentItem + ", count: " + maxCount);

    }
}