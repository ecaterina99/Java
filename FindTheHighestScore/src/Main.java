/*
Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
You need to return the highest scoring word as a string.
 */

public class Main {
    public static void main(String[] args) {

        String s = "man i need a taxi up to ubud";
        String res = "";
        int maxScore = 0;
        for (String w : s.split(" ")) {
            if (findSum(w) > maxScore) {
                maxScore = findSum(w);
                res = w;
            }
        }
        System.out.println(maxScore + " " + res);
    }

    public static int findSum(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            int asciiValueOfInputChar = (int) word.charAt(i);
            int position = asciiValueOfInputChar - 96;
            sum += position;
        }

        return sum;
    }
}