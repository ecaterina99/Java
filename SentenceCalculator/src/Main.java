/**
 * Calculate the total score (sum of the individual character scores) of a sentence
 * given the following score rules for each allowed group of characters:
 * Lower case [a-z]: 'a'=1, 'b'=2, 'c'=3, ..., 'z'=26
 * Upper case [A-Z]: 'A'=2, 'B'=4, 'C'=6, ..., 'Z'=52
 * Digits [0-9] their numeric value: '0'=0, '1'=1, '2'=2, ..., '9'=9
 * Other characters: 0 value
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String s = "Oops, I did it again 333!";
        int sum = 0;
        int value = 2;

        HashMap<Character, Integer> digitsLowerCase = new HashMap<>();
        HashMap<Character, Integer> digitsUpperCase = new HashMap<>();
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Character> letters = new ArrayList<>(26);
        ArrayList<Character> lettersUpperCase = new ArrayList<>(26);


        for (int i = 0; i < 26; i++) {
            letters.add((char) ('a' + i));
        }
        for (int i = 0; i < 26; i++) {
            lettersUpperCase.add((char) ('A' + i));
        }


        for (int i = 0; i < letters.size(); i++) {
            digitsLowerCase.put(letters.get(i), i + 1);
        }

        for (Character character : lettersUpperCase) {
            digitsUpperCase.put(character, value);
            value = value + 2;
        }


        for (int i = 0; i < s.length(); i++) {

            if (Character.isLowerCase(s.charAt(i))) {

                for (Map.Entry<Character, Integer> entry : digitsLowerCase.entrySet()) {
                    if (entry.getKey() == s.charAt(i)) {
                        values.add(entry.getValue());
                    }
                }
            } else if (Character.isUpperCase(s.charAt(i))) {
                for (Map.Entry<Character, Integer> entry : digitsUpperCase.entrySet()) {
                    if (entry.getKey() == s.charAt(i)) {
                        values.add(entry.getValue());
                    }
                }
            } else if (Character.isDigit(s.charAt(i))) {
                value = Integer.parseInt(s.charAt(i) + "");
                values.add(value);
            } else {
                value = 0;
            }
        }

        for (Integer integer : values) {
            System.out.print(integer + " ");
            sum += integer;
        }

        System.out.println("The sum is: " + sum);

    }

}
