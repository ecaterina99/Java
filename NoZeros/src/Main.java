public class Main {
    public static void main(String[] args) {
        int n = 96000;
        if (n == 0)
            System.out.println(n);

        while (n % 10 == 0)
            n /= 10;
        System.out.println(n);

    }
}