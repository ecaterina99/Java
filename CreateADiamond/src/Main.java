/*
You need to return a string that looks like a diamond shape when printed on the screen,
using asterisk (*) characters. Trailing spaces should be removed, and every line must
be terminated with a newline character (\n). */
public class Main {
    public static void main(String[] args) {

        int n = 3;
        StringBuilder sb = new StringBuilder();
        String space = " ";
        String result;
        if (n % 2 == 0 || n <= 0) {
            System.out.println("Error");
        } else {
            for (int i = 1; i < n; i += 2) {
                sb.append(space.repeat(Math.max(0, (n - i) / 2)));
                sb.append("*".repeat(Math.max(0, i)));
                sb.append("\n");
            }
            for (int i = n; i > 0; i -= 2) {
                sb.append(space.repeat(Math.max(0, (n - i) / 2)));
                sb.append("*".repeat(i));
                if (i > 1) sb.append("\n");
            }
        }
        result = sb.toString();
        System.out.println(result);

    }
}