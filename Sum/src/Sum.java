/*
Given two integers a and b, which can be positive or negative, find the sum of all the integers
between and including them and return it. If the two numbers are equal return a or b.
Note: a and b are not ordered!
 */

public class Sum {
    public int GetSum(int a, int b) {

        int sum = 0;
        int min = 0;
        int max = 0;
        if (a < b) {
            min = a;
            max = b;
        } else if (a > b) {
            min = b;
            max = a;
        } else {
            sum = a;
        }

        for (int i = min; i <= max; i++) {
            sum += i;
        }

        return sum;
        //  return (a + b) * (Math.abs(a - b) + 1) / 2;  //
    }



    /*
    This kata is about multiplying a given number by eight if it is an even number and by nine otherwise.
     */


    public static int simpleMultiplication(int n) {
        int result = 0;
        if ( n % 2 == 0 ) {
            result = n * 8;
        }
        else {
            result = n * 9;
        }
        return result;
    }

}