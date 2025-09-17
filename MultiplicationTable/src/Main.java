//Your task, is to create N×N multiplication table, of size provided in parameter.
public class Main {
    public static void main(String[] args) {

        int n= 4;
        int[][] multiplicationTable= new int[n][n];
        int c = 1;

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                multiplicationTable[i][j]= (j+c)*(i+c);
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(multiplicationTable[i][j]+ " ");
            }
            System.out.println();
        }

    }
}