/*Given a random non-negative number, you have to return the digits of this number within an array in reverse order.

*/

import java.util.Arrays;


public class ReversedLong {
    public static int[] digitize(long n) {


        String numberStr = String.valueOf(n);
        System.out.println("Number string: " + numberStr);

        //Size
        int size = numberStr.length();
        System.out.println("length: " + size);

        String reverseStr = "";
        char ch;

        for (int i = 0; i < size; i++) {

            // extracts each character
            ch = numberStr.charAt(i);
            reverseStr = ch + reverseStr;

        }

        System.out.println(reverseStr);

        int arr[] = new int[size];

        String[] separateNum = reverseStr.split("");


        for (int i = 0; i < size; i++) {


            int number = Integer.valueOf(separateNum[i]);
            arr[i] = number;

        }
        System.out.println("new arr:" + Arrays.toString(arr));

        return arr;
    }
}
