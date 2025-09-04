/*
Given a string, capitalize the letters that occupy even indexes and odd indexes separately,
and return as shown below. Index 0 will be considered even.
 */

public class Main {
    public static void main(String[] args) {
        String s = "abcdef";
        StringBuilder sb = new StringBuilder();
        String[] words = new String[2];

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));
            }
        }
        String res = sb.toString();
        words[0] = sb.toString();
        sb = new StringBuilder();

        for (int i = 0; i < res.length(); i++) {
            if (Character.isUpperCase(res.charAt(i))) {
                sb.append(Character.toLowerCase(res.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(res.charAt(i)));
            }
        }
        words[1] = sb.toString();
        for (String word : words) {
            System.out.println(word);
        }
    }
}