/*
You will be given an array and a limit value.
You must check that all values in the array are below or equal to the limit value.
If they are, return true. Else, return false.
 */

public class Main {
    public static void main(String[] args) {
        int[] a = {80, 117, 115, 104, 45, 85, 112, 115};
        int limit = 120;
        boolean flag = true;
        int counter = 0;

        for (int j : a) {
            if (j > limit) {
                counter++;
            }
        }
        if (counter>0){
            flag = false;
        }else {
            flag = true;
        }
        System.out.println(flag);
    }
}