public class RecursionTest2 {
    public static void main(String[] args) {

        System.out.println(power(3, 8));
    }

    private static int power(int base, int power) {

        if (power < 1) return 1; //base case
        return base * power(base, power - 1); //recursive case
    }
}
