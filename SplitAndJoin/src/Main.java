import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[][] arr = {
                {1},
                {2, 3},
                {4, 5, 6},
                {7, 8, 9, 10}
        };
        int cntAll = 0;
        int cntSubarr = 0;
        ArrayList<Integer> arrAllNumbers = new ArrayList<>();
        ArrayList<Integer> arrAllSizes = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                cntAll++;
                arrAllNumbers.add(arr[i][j]);
            }
            cntSubarr++;
            arrAllSizes.add(cntSubarr);
        }

        System.out.println("first arr");
        for (Integer arrAllNumber : arrAllNumbers) {
            System.out.println(arrAllNumber);
        }
        System.out.println("second arr");

        for (Integer arrAllSize : arrAllSizes) {
            System.out.println(arrAllSize);
        }

    }
}