/*
Your job is to take that array and find an index N where the sum of the integers to the left of N
is equal to the sum of the integers to the right of N.
 */
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        int i, j;
        int leftsum, rightsum;
        int n = arr.length;
        for (i = 0; i < n; ++i) {
            leftsum = 0;
            rightsum = 0;
            for (j = 0; j < i; j++)
                leftsum += arr[j];
            for (j = i + 1; j < n; j++)
                rightsum += arr[j];
            if (leftsum == rightsum)
                System.out.println("index =" +i);
        }
    }
}