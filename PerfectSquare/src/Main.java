//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        long sq = 624;
        double x = Math.sqrt(sq);
        long next;
        boolean isInteger;

        if (x % 1 == 0) {
            isInteger = true;
        } else {
            isInteger = false;
        }

        if (isInteger) {
            next = (long) ((x + 1) * (x + 1));
        } else {
            next = -1;
        }
        System.out.println(next);
    }
}