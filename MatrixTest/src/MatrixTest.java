public class MatrixTest {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 0, 1}
        };

        int[][] matrix2 = {
                {4, 1, 6},
                {2, 3, 5},
                {7, 4, 3}
        };

        int[][] matrixSum = new int[3][3];

        for (int i = 0; i < matrixSum.length; i++) {
            for (int j = 0; j < matrixSum.length; j++) {
                matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        for (int i = 0; i < matrixSum.length; i++) {
            for (int j = 0; j < matrixSum.length; j++) {
                System.out.print(matrixSum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
