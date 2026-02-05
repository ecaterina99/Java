import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[] rowWeights = new int[2];

        int sumFirst = 0;
        int sumSecond = 0;
        int[] weights = {70, 58, 75, 34, 91};

        if (weights.length == 1) {
            rowWeights[0] = weights[0];
            rowWeights[1] = 0;
        } else {
            for (int i = 0; i < weights.length; i++) {
                if (i % 2 == 0) {
                    sumFirst += weights[i];
                } else {
                    sumSecond += weights[i];
                }
            }
        }

        rowWeights[0] = sumFirst;
        rowWeights[1] = sumSecond;

        for (int weight : rowWeights) {
            System.out.println(weight);
        }

    }
}