import java.util.Scanner;

/**
 * Given a number, say prod, we search two Fibonacci numbers F(n) and F(n+1) verifying:
 * F(n)∗F(n+1)=prod
 * Your function takes an integer (prod) and returns an array/tuple
 * if F(n) * F(n+1) = prod:
 * (F(n), F(n+1), true)
 * If you do not find two consecutive F(n) verifying F(n) * F(n+1) = prod:
 * (F(n), F(n+1), false)
 * where F(n) is the smallest one such as F(n) * F(n+1) > prod.
 */
public class Main {
    public static void main(String[] args) {
        long[] result1 = productFib(4895);
        long[] result2 = productFib(5895);

        System.out.println(java.util.Arrays.toString(result1));
        System.out.println(java.util.Arrays.toString(result2));
    }

    public static long[] productFib(long prod) {
        long a = 0;
        long b = 1;

        while (a * b < prod) {
            long next = a + b;
            a = b;
            b = next;
        }

        return new long[] {a, b, (a * b == prod) ? 1 : 0};
    }
}