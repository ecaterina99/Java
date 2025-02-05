/*
Create a function that accepts a string and a single character,
and returns an integer of the count of occurrences the 2nd argument is found in the first one.
If no occurrences can be found, a count of 0 should be returned.
 */

public class CountCharacter {
    public static void main(String[] args) {
        String str = "Hello";
        char letter = 'l';
        char[] arr = str.toCharArray();
        int cnt = 0;
        for (char c : arr) {
            if (c == letter) {
                cnt++;
            }
        }
        System.out.println(Math.max(cnt, 0));
    }
}