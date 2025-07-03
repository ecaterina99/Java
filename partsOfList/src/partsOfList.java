/*
Write a function partlist that gives all the ways to divide a list (an array)
of at least two elements into two non-empty parts.
Each two non empty parts will be in a pair
Each part will be in a string
Elements of a pair must be in the same order as in the original array.
Examples of returns in different languages:
a = ["az", "toto", "picaro", "zone", "kiwi"] -->
[["az", "toto picaro zone kiwi"], ["az toto", "picaro zone kiwi"], ["az toto picaro", "zone kiwi"],
["az toto picaro zone", "kiwi"]]
 */

import java.util.ArrayList;

public class partsOfList {
    public static void main(String[] args) {

        String arr[] = {"az", "toto", "picaro", "zone", "kiwi"};
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < arr.length; i++) {
            ArrayList<String> firstPart = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                firstPart.add(arr[j]);
            }

            ArrayList<String> secondPart = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                secondPart.add(arr[j]);
            }
            result.add(firstPart);
            String listString = String.join(" ", firstPart);
            result.add(secondPart);
            String list2String = String.join(" ", secondPart);

            sb.append("[");
            sb.append("\"").append(listString).append("\"");
            sb.append(",");
            sb.append("\"").append(list2String).append("\"");
            sb.append("]");


            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
