//square every digit of a number and concatenate them.

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int n = 9119;
        int squareN;

        String s = String.valueOf(n);

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int temp = Integer.parseInt(s.substring(i, i + 1));
            res.add(temp);
        }
        StringBuilder sb = new StringBuilder();
        for (int temp : res) {
            temp = temp * temp;
            sb.append(temp);
        }

        squareN = Integer.parseInt(sb.toString());
        System.out.println(squareN);

    }
}