/*
You will be given a number and you will need to return it as a string in Expanded Form. For example:
   12 --> "10 + 2"
   45 --> "40 + 5"
   70304 --> "70000 + 300 + 4"
 */

import java.util.ArrayList;

public class NumberInExpandedForm {
    public static void main(String[] args) {
        int num = 12055;
        String res = "";

        String stringNumber = Integer.toString(num);
        ArrayList<String> result = new ArrayList<>(stringNumber.length());

        for (int i = 0; i < stringNumber.length(); i++) {
            if (stringNumber.charAt(i) != '0') {
                int firstDigit = Character.getNumericValue(stringNumber.charAt(i));
                int numOfZeros = stringNumber.length() - 1 - i;
                int fullNum = firstDigit * (int) Math.pow(10, numOfZeros);
                result.add(String.valueOf(fullNum));
            }
        }
        res = String.join(" + ", result);
        System.out.println(res);
    }
}