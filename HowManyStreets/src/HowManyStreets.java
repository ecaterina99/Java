/*
Inputs:
A list (or array, depending on language) of streets that intersect MAX_STREET.
(2) A list (or array, depending on language) of drivers. Each driver is represented by a pair of streets.
The first element of the pair is the street where they enter MAX_STREET; the second is the street they exit.
The driver crosses all the streets between those two streets.
Output:
A list  showing how many streets each driver crosses.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyStreets {


    public static int[] countStreets(String[] streets, String[][] drivers) {
        int n = streets.length;
        int d = drivers.length;
        int[] result = new int[d];

        Map<String, Integer> streetIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            streetIndex.put(streets[i], i);
            System.out.println(streets[i]);
        }

        for (int j = 0; j < d; j++) {
            int start = streetIndex.get(drivers[j][0]);
            int end = streetIndex.get(drivers[j][1]);

            result[j] = Math.abs(end - start) - 1;
            System.out.println(start + " " + end + " = " + result[j]);
        }

        return result;
    }

    public static void main(String[] args) {
        final String[] streets = {"first", "second", "third", "fourth", "fifth", "sixth", "seven"};
        final String[][] drivers = {{"first", "second"}, {"second", "seven"}, {"sixth", "fourth"}};


        System.out.println(Arrays.toString(countStreets(streets, drivers)));
    }
}


  /*    int rows = drivers.length;
        int result = 0;
        int[] resArray = new int[rows];

        for (int i = 0; i < streets.length; i++) {
            for (int j = 0; j < rows; j++) {
                String target1 = drivers[j][0];

               if (streets[i].equals(target1)) {
                    String target2 = drivers[j][1];
                    for (int k = 0; k < streets.length; k++) {
                        if (streets[k].equals(target2)) {
                            result = k - i;
                            if (result > 0) {
                                result = result - 1;
                            } else {
                                result = -1 - (result);
                            }
                        }
                        resArray[j] = result;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(resArray));
    }

}

*/
