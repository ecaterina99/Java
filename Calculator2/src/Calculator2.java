public class Calculator2 {
    public static void main(String[] args) {
        int x = 16;
        int y = 8;
        char op = '*';

        if (op == '+') {
            System.out.println(x + y);
        } else if (op == '-') {
            System.out.println(x - y);
        } else if (op == '*') {
            System.out.println(x * y);
        } else if (op == '/') {
            System.out.println(x / y);
        } else {
            System.out.println("Incorrect operation");
        }
    }

}
