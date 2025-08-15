import java.util.ArrayList;
import java.util.Arrays;

/*
Your task is to write a function that takes a string and return a new string with all vowels removed.

 */

public class Main {
    public static void main(String[] args) {

        String str = "This website is for losers LOL!";
        char[] strArr = str.toCharArray();
        StringBuilder result = new StringBuilder();
        ArrayList<Character> letters = new ArrayList<>(Arrays.asList('a', 'i', 'e', 'o', 'u'));

        for (int i = 0; i < strArr.length; i++) {
            if(!letters.contains(Character.toLowerCase(strArr[i]))){
            result.append(strArr[i]);
            }
        }
        System.out.println(result);

    }
}