/*
Write a function which takes a positive integer and returns the number of special steps
needed to obtain a palindrome. The special step is: "reverse the digits,
and add to the original number". If the resulting number is not a palindrome,
repeat the procedure with the sum until the resulting number is a palindrome.
If the input number is already a palindrome, the number of steps is 0.
 */
public class Main {
    public static void main(String[] args) {

        long n = 10;
        int cnt = 1;

        if (n < 10) {
            cnt = 0;
        } else if (hasSameDigits((int) n)) {
            cnt = 0;
        } else {
            cnt = checkPalindrome((int) n, cnt);
        }
        System.out.println("The final result is:" + cnt);
    }


    public static int checkPalindrome(int input, int cnt) {


        String reverseInt = Integer.toString(input);
        int reverseNumber;

        StringBuilder reverse = new StringBuilder();
        for (int i = reverseInt.length() - 1; i >= 0; i--) {
            char ch = reverseInt.charAt(i);
            reverse.append(ch);
        }
        reverseNumber = Integer.parseInt(reverse.toString());
        System.out.println("The riverse number is:" + reverseNumber);

        // add origin number

        int sum = input + reverseNumber;
        System.out.println("The sum is:" + sum);

        boolean palindrome = false;


        String sumString = Integer.toString(sum);
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        int length = 0;


        length = sumString.length() / 2;

        for (int i = 0; i < length; i++) {
            char ch = sumString.charAt(i);
            first.append(ch);
        }
        for (int i = sumString.length() - 1; i >= length; i--) {
            char ch = sumString.charAt(i);
            second.append(ch);
        }


        System.out.println(first + " " + second);


        if (first.toString().contentEquals(second)) {
            palindrome = true;

        }


        if (!palindrome) {
            input = sum;
            cnt++;
            System.out.println("Not a palindrome, cnt:" + cnt);
            return checkPalindrome(input, cnt);


        } else {
            System.out.println("Palindrome");
            return cnt;

        }
    }


    public static boolean hasSameDigits(int number) {
        String s = String.valueOf(number);
        char first = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != first) {
                return false;
            }
        }
        return true;
    }

}