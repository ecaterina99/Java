//You are given an odd-length array of integers, all of them are the same, except for one single number.
public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 1};
        int res = 0;

        if (numbers[0] == numbers[1]) {
            int i = numbers[0];
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[j] != i) {
                    res = numbers[j];
                }
            }
        } else if (numbers[0] == numbers[2]) {
            res = numbers[1];
        } else {
            res = numbers[0];
        }
        System.out.println(res);
    }
}