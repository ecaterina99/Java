import java.util.*;

/**
 * Write a function named first_non_repeating_letter† that takes a string input,
 * and returns the first character that is not repeated anywhere in the string.
 * For example, if given the input 'stress', the function should return 't',
 * since the letter t only occurs once in the string, and occurs first in the string.
 * Upper- and lowercase letters are considered the same character,
 * but the function should return the correct case for the initial letter.
 * For example, the input 'sTreSS' should return 'T'.
 */
public class Main {
    public static void main(String[] args) {

        String s = "sTreSS";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        ArrayList<Character> distinctChars = new ArrayList<>();
        String string = s.toLowerCase();
        String result = " ";

        for (char c : string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.entrySet().removeIf(entry -> entry.getValue() > 1);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.toLowerCase().charAt(i);
                if (entry.getKey() == c) {
                    distinctChars.add(s.charAt(i));
                }
            }
        }

        if(distinctChars.isEmpty()) {
            result = "";
        }else {
            result = String.valueOf(distinctChars.get(0));
        }
        System.out.println("Result: " + result);

    }
}
