/*
You will receive the bookseller's stocklist and a list of categories.
Your task is to find the total number of books in the bookseller's stocklist,
with the category codes in the list of categories. Note: the codes are in the same order in both lists.
Return the result as a string described in the example below.
If any of the input lists is empty, return an empty string.

Example
# the bookseller's stocklist:
"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"

# list of categories:
"A", "B", "C", "W"

# result:
"(A : 20) - (B : 114) - (C : 50) - (W : 0)"
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lstOfArt = new ArrayList<>
                (Arrays.asList("ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"));
        ArrayList<String> lstOf1stLetter = new ArrayList<>(Arrays.asList("A", "B", "C", "W"));
        ArrayList<Character> charLstOf1stLetter = new ArrayList<>();
        for (String s : lstOf1stLetter) {
            for (char c : s.toCharArray()) {
                charLstOf1stLetter.add(c);
            }
        }
        char firstLetter;
        int quantity;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> finalMap = new HashMap<>();

        for (String s : lstOfArt) {
            firstLetter = s.charAt(0);
            String number = s.replaceAll("[^0-9]", "");
            quantity = Integer.parseInt(number);

            if (map.containsKey(firstLetter)) {
                quantity = map.merge(firstLetter, quantity, Integer::sum);
            }

            map.put(firstLetter, quantity);
        }

        boolean consists = false;

        for (Character character : charLstOf1stLetter) {
            if (map.containsKey(character)) {
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getKey() == character) {
                        finalMap.put(entry.getKey(), entry.getValue());
                        consists = true;
                    }
                }
            } else {
                finalMap.put(character, 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int size = finalMap.size();


        String result = "";

        if (consists) {
            for (Map.Entry<Character, Integer> entry : finalMap.entrySet()) {
                sb.append("(").append(entry.getKey()).append(" : ").append(entry.getValue()).append(")");
                if (++count < size) {
                    sb.append(" - ");
                }
            }
        } else {
            sb.append(" ");
        }
        result = sb.toString();

        System.out.println(result);

    }
}