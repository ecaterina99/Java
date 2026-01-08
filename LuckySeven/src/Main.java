/**
 * A "Lucky Seven" is the number seven surrounded by numbers that add up to form a perfect cube.
 * The surrounding numbers will be described as the numbers directly above, below, and next to
 * (not diagonally) the number 7. You will be given a 2D array containing at least 1 lucky seven.
 * Your function should return the number of lucky sevens in the array.
 */

public class Main {
    public static void main(String[] args) {

        int[][] arr = {
                {186, 946, 992, 578, 286, 10, 295, 499, 369},
                {408, 16, 347, 608, 827, 7, 7, 727, 858},
                {5, 7, 4, 638, 409, 472, 817, 1, 531},
                {792, 2, 179, 7, 133, 684, 0, 7, 0},
                {764, 374, 962, 50, 46, 95, 474, 0, 460},
                {165, 7, 133, 5, 7, 11, 825, 40, 626},
                {240, 57, 954, 447, 2, 551, 1, 7, 17},
                {7, 738, 7, 450, 37, 7, 120, 6, 7},
                {7, 683, 902, 66, 402, 21, 870, 323, 233}
        };

        int m;
        int n;
        int sum;
        boolean lucky;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 7 && i != 0 && j != 0 && i != arr.length-1  && j != arr[i].length-1 ) {
                    m = i;
                    n = j;
                    System.out.print(arr[i][j] + " Position: row " + m + "; column " + n + ". ");
                    sum = arr[i - 1][j] + arr[i + 1][j] + arr[i][j - 1] + arr[i][j + 1];
                    System.out.println(sum);
                    int c = (int) Math.round(Math.cbrt(sum));
                    lucky = c * c * c == sum;
                    System.out.println(lucky);
                    if (lucky) {
                        cnt++;
                    }
                }
            }
            System.out.println();
        }
        System.out.println("The result is: " + cnt);

    }
}