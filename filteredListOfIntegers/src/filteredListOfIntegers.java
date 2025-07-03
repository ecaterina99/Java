/*
In this kata you will create a function that takes a list of non-negative integers and strings
and returns a new list with the strings filtered out.
 */

import java.util.ArrayList;
import java.util.List;

public class filteredListOfIntegers {
    public static void main(String[] args) {

        List<Object> filterList = new ArrayList<>();
        filterList.add(1);
        filterList.add(2);
        filterList.add("a");
        filterList.add("b");

        List<Object> result = new ArrayList<>();
        for(Object o : filterList) {
            if(o instanceof Integer) {
                result.add(o);
            }
        }
        System.out.println(result);


    }
}