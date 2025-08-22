import java.util.ArrayList;

//There is an array with some numbers. All numbers are equal except for one. Try to find it!
public class Main {
    public static void main(String[] args) {

        double[] arr = {0.55, 0.55, 0.55, 0.55, 2};
        double target = 0.0;

        if (arr[0] == arr[arr.length - 1]) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    target = arr[i];
                }
            }
        } else if (arr[0] == arr[1] && arr[arr.length - 1] != arr[arr.length - 2]) {
            target = arr[arr.length - 1];
        } else {
            target = arr[0];
        }

        System.out.println(target);
    }
}