/*
Write a function that receives a list of pairs and returns the number of days that the company
is represented in the foreign country. The first number of the pair is the number of the day of
arrival and the second number of the pair is the day of departure of someone who travels,
i.e. 1 january is number 1 and 31 of december is 365.
 */

import java.util.HashSet;

public class HowManyDays {
    public static void main(String[] args) {
        int trips[][] = {{2, 8}, {220, 229}, {10, 16}};
        HashSet<Integer> days = new HashSet<>();

        for (int[] trip : trips) {
            int start = trip[0];
            int end = trip[1];
            for (int i = start; i <= end; i++) {
                days.add(i);
            }
        }
        System.out.println(days.size());
    }
}