/*
Given an integer as input,  round it to the next (meaning, "greater than or equal") multiple of 5.
Examples:
input:    output:
0    ->   0
3    ->   5
12   ->   15
 */
public class Main {
    public static void main(String[] args) {
        int number = 2;
        int res;
        if (number == 0) {
            res = 0;
        }
        else {
            res = (int) (Math.ceil(number / 5.0f) * 5);
        }
        System.out.println(res);
    }
}