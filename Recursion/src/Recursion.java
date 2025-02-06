public class Recursion {
    public static void main(String[] args) {
        counter(3);
        System.out.println(factorial(10));
    }
    private static void counter(int n) {
        if(n == 0){
            return;
        }
        System.out.println(n);
        counter(n - 1);
    }

    private static int factorial(int m) {
        if(m == 1){
            return 1;
        }
        return m * factorial(m-1);
    }
}