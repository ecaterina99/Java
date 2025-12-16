/**
 * Create a method named "rotate" that returns a given array with the elements inside
 * the array rotated n spaces. If n is greater than 0 it should rotate the array to the right.
 * If n is less than 0 it should rotate the array to the left. If n is 0,
 * then it should return the array unchanged.
 */

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        Object[] data = new Object[]{1,2,3,4,5,6,7,0};
        int n = 2;

        int size = data.length*2;
        ArrayList<Object> input = new ArrayList<>(size);
        ArrayList<Object >result = new ArrayList<>(data.length);

        for (int j = 0;j < 2; j++) {
            for (Object datum : data) {
                Object object = datum;
                input.add(object);
            }
    }

        int d = data.length;


        if(n>0 && n>d) {
            d= n%d;
            for (int i = data.length - d; i < input.size() - d; i++) {
                Object object = input.get(i);
                result.add(object);
            }
        }else if(n>0 && n<=d) {
            d = n;
            for (int i = data.length - d; i < input.size() - d; i++) {
                Object object = input.get(i);
                result.add(object);
            }
        }
          else if(n<0 && n * -1 <= d) {
            d = n*-1;
            for (int i = d; i < data.length+d; i++) {
                Object object = input.get(i);
                result.add(object);
            }
        }

        else if(n<0 && n * -1 >= d) {
            d = n*-1%d;;
            for (int i = d; i < data.length+d; i++) {
                Object object = input.get(i);
                result.add(object);
            }
        }
        else if(n==0){
            for(int i= 0 ; i< data.length; i++){
                Object object = input.get(i);
                result.add(object);
            }
        }
        else{
            result.add(0);
        }
        Object[] array = result.toArray();

        for (Object object : array) {
            System.out.println(object);
        }
    }
}
