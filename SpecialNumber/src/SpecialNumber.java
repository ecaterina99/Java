/*
A number is a Special Number if its digits only consists of 0, 1, 2, 3, 4 or 5
Given a number, determine if it is a special number or not.
The number passed will be positive (N > 0)
All single-digit numbers within the interval [1:5] are considered special numbers
 */

public class SpecialNumber {

    public static void main(String[] args) {
        int number = 559;
        String str = String.valueOf(number);
        String pattern = ".*[^1-5].*";
        if (str.matches(pattern) || str.equals("0")) {
            System.out.println("not contains");
        }else{
            System.out.println("contains");
        }

    }
}