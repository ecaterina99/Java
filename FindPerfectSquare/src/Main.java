//Given an integral number, determine if it's a square number

public class Main {
    public static void main(String[] args) {

        int n = 10;
        int x = (int) Math.sqrt(n);
        boolean isSquare = false;

        System.out.println(x);
        if (x * x == n) {
            isSquare = true;
        } else {
            isSquare = false;
        }
        System.out.println("The result is:" + isSquare);
    }
}