/*
Simple, given a string of words, return the length of the shortest word(s).
String will never be empty and you do not need to account for different data types.
 */

import java.util.Arrays;

public class ShortestWord {
    public static int findShort(String s) {
        String[] words = s.split(" ");
        int numberWords = words.length;

        int min = words[0].length();

        for (String word : words) {
            if (word.length() < min) {
                min = word.length();
            }
        }
        return min;
    }
}