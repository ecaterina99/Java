/*
Check to see if a string has the same amount of 'x's and 'o's.
The method must return a boolean and be case insensitive. The string can contain any char.
 */

public class AmountOfXAndO {
    public static void main(String[] args) {
        String str = "XOXO";
        boolean getXO = true;

        char[] arr = str.toCharArray();
        int cntX = 0;
        int cntO = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'x' || arr[i] == 'X') {
                cntX++;
            } else if (arr[i] == 'o' || arr[i] == 'O') {
                cntO++;
            }
        }
        if (cntX == cntO) {
            getXO = true;
        } else {
            getXO = false;
        }
        System.out.println(getXO);
    }
}