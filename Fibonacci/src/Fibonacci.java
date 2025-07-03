import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {

        int n = 100;
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        System.out.println(fibonacciMemoization(n, mem));
    }

    //Memoization effective method
//O(n)
    private static long fibonacciMemoization(int n, long[] mem) {
        if (mem[n] != -1) {
            return mem[n];
        }
        if (n <= 1) {
            return n;
        }
        long result = fibonacciMemoization(n - 1, mem) + fibonacciMemoization(n - 2, mem);
        mem[n] = result;
        return result;
    }
}


//Simple, not effective method
//O(2^n)
    /*
    static public int fibonacciNaive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
    }

    //effective method
    static public long fibonacciEffective(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
        */
