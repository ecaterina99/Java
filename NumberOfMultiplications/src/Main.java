import java.util.ArrayList;

/*
Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
which is the number of times you must multiply the digits in num until you reach a single digit.
 */

public class Main {
    public static void main(String[] args) {
        long n = 999;
        int res = 10;
        int cnt = 0;
        int l = String.valueOf(n).length();
        if (l == 1) {
            cnt = 0;
        } else {
            while (res > 9) {
                int length = String.valueOf(n).length();
                ArrayList<Integer> digits = new ArrayList<>();

                for (int i = 0; i < length; i++) {
                    String number = String.valueOf(n);
                    int digit = Character.getNumericValue(number.charAt(i));
                    digits.add(digit);
                }
                res = 1;
                for (Integer digit : digits) {
                    res *= digit;
                }
                n = res;
                digits.clear();
                cnt++;
                System.out.println(res);
            }
        }
        System.out.println("The number of multiplications is:"+cnt);
    }
}