/*
Your task is to write a function which returns the sum of a sequence of integers.
The sequence is defined by 3 non-negative values: begin, end, step.
If begin value is greater than the end, your function should return 0.
If end is not the result of an integer number of steps, then don't add it to the sum.
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        int step = 3;
        int end = 5;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int res=0;
        if(start > end) {
            res= 0;
        }else{
            list.add(start);
            while(start <= end-step) {
                start = start + step;
                list.add(start);
            }
        }
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
            res += list.get(i);
        }
        System.out.println(res);
    }
}