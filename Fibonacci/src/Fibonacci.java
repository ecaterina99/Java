public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciEffective(1));
        System.out.println(fibonacciEffective(5));
        System.out.println(fibonacciEffective(10));
        System.out.println(fibonacciEffective(50));
    }

    //Simple, not effective method
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
    }
}