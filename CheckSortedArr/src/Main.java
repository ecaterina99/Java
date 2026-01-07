import java.util.ArrayList;
/**
 * Complete the method which accepts an array of integers, and returns one of the following:
 * "yes, ascending" - if the numbers in the array are sorted in ascending order
 * "yes, descending" - if the numbers in the array are sorted in descending order
 * "no" - otherwise
 * The order does not have to be strict: a sorted array can contain consecutive duplicates.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {3,3,2,1};
        String result = "";
        ArrayList<Character> res = new ArrayList<>();

        for(int i = 0; i<array.length-1; i++){
            if(array[i] < array[i+1] ){
              res.add('+');
            }
            else if(array[i]> array[i+1]){
                res.add('-');            }
            else{
                res.add('=');
            }
        }

        boolean foundMinus = String.valueOf(res).indexOf('-') >= 0;
        boolean foundPlus = String.valueOf(res).indexOf('+') >= 0;

        if(foundMinus && !foundPlus){
            result = "yes, descending";
        }
        else if(!foundMinus && foundPlus){
            result = "yes, ascending";
        }
        else{
            result = "no";
        }
        System.out.println(result);
    }
}