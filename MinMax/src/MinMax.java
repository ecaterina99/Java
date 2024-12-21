/*Your task is to make two functions
        ( max and min, or maximum and minimum, etc., depending on the language )
that receive a list of integers as input, and return the largest and lowest number in that list,
respectively. Each function returns one number.Your task is to make two functions ( max and min, or maximum and minimum, etc., depending on the language ) that receive a list of integers as input, and return the largest and lowest number in that list, respectively. Each function returns one number.
*/


public class MinMax {

    public int min(int[] list) {
        int min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
            }
        }
        System.out.println(min);
        return min;
    }

    public int max(int[] list) {
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        System.out.println(max);
        return max;
    }
}
