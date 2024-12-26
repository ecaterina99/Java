
/*
In this little assignment you are given a string of space separated numbers,
and have to return the highest and lowest number.
All numbers are valid Int32, no need to validate them.
There will always be at least one number in the input string.
Output string must be two numbers separated by a single space, and highest number is first.
 */

import java.util.Arrays;

public class Highest_Lowest {
    public static String highAndLow(String numbers) {

        // Get the length of the input string
        int size = numbers.length();
        int numbersArray[] = new int[size];


        // Split the input string into individual numbers
        String[] separatedNum = numbers.split(" ");

        // Initialize min and max with the first number in the array
        int min = Integer.valueOf(separatedNum[0]);
        int max = Integer.valueOf(separatedNum[0]);

        // Iterate through the separated numbers to find the minimum and maximum values
        for (String num : separatedNum) {

            //convert string to int
            int number = Integer.valueOf(num);
            // Check if the current number is smaller than the current minimum
            if (number < min) {
                min = number;
            }
            // Check if the current number is larger than the current maximum
            if (number > max) {
                max = number;
            }

        }
        // Output the minimum and maximum values
        System.out.println("Min number: " + min);
        System.out.println("Max number: " + max);
        // Return the result in the format "max min"
        return max + " " + min;
    }
}
