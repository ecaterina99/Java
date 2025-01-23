/*
Given a string str, reverse it and omit all non-alphabetic characters.
A string consists of lowercase latin letters, digits and symbols.
 */

import java.util.ArrayList;
import java.util.List;


public class ReverseLetter {
    public static void main(String[] args) {

        String str = "qwe*2rty";
        char[] arr = str.toCharArray();
        char[] reverseArr = new char[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            reverseArr[i] = arr[arr.length - i - 1];
        }

        List<Character> onlyChars = new ArrayList<>();
        for (char c : reverseArr) {
            onlyChars.add(c);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!Character.isLetter(onlyChars.get(i))) {
                onlyChars.remove(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : onlyChars) {
            sb.append(c);
        }
        String result = sb.toString();
        System.out.println(result);

        // Second solution;

        String str2 = "an5iret&acE";
        StringBuilder output = new StringBuilder(str2.replaceAll("[^a-zA-Z]", "")).reverse();
        System.out.println(output);


    }
}

