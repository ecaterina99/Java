import java.util.ArrayList;

/*
In this simple Kata your task is to create a function that turns a string into a Mexican Wave.
You will be passed a string and you must return an array of strings where an uppercase letter
is a person standing up.
The input string will always consist of lowercase letters and spaces, but may be empty,
in which case you must return an empty array. 2.  If the character in the string is whitespace
then pass over it as if it was an empty seat
 */

public class Main {
    public static void main(String[] args) {
        String str = "Two words";
        int length = str.length();
        System.out.println(length);
        char[] input = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        if(str.isEmpty()){
            res = new ArrayList<>();
        }else{

            for (int i = 0; i < length; i++) {
                if (input[i] != ' ') {
                    str = str.toLowerCase();

                    StringBuilder sb = new StringBuilder(str);
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));

                    res.add(sb.toString());
                }
            }

        }
        String[] arr = res.toArray(new String[0]);
        for (String s : arr) {
            System.out.println(s);
        }

    }
}