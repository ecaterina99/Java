//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[][] arr = {{11, 12, 14, 54}, {67, 89, 90, 56}, {7, 9, 4, 3}, {9, 8, 6, 7}};
        int m = arr.length;
        int n = arr[0].length;
        int minimum = arr[0][0];
        int sumOfMinimums = 0;


        for(int i = 0; i < m; i++){
            minimum = arr[i][0];

            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
                if(arr[i][j] < minimum){
                    minimum = arr[i][j];
                }
            }
            System.out.println("minimum = " + minimum);
            sumOfMinimums = sumOfMinimums + minimum;
            System.out.println("sum of minimum = " + sumOfMinimums);
            System.out.println();
        }

        System.out.println(sumOfMinimums);

    }

}