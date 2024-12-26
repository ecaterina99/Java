import java.util.Arrays;

public class AveragePoints {
    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {


        int sumClassmatesPoints = 0;
        double averageClassmatesPoints;

        System.out.println(Arrays.toString(classPoints));


        for (int i = 0; i < classPoints.length; i++) {
            int classmatePoints = classPoints[i];
            sumClassmatesPoints = sumClassmatesPoints + classmatePoints;
        }
        averageClassmatesPoints = sumClassmatesPoints / classPoints.length;


        System.out.println("The sum of classmates points: " + sumClassmatesPoints);
        System.out.println("The average of classmates points: " + averageClassmatesPoints);
        System.out.println("Total grades: " + classPoints.length + 1);
        System.out.println("My points: " + yourPoints);

        double totalAverage = (averageClassmatesPoints + (double) yourPoints) / ((double) classPoints.length + 1);

        System.out.println("Total average of points: " + totalAverage);

        if (totalAverage > yourPoints) {
            return false;
        } else {
            return true;
        }

    }


/*
Given an array of integers your solution should find the smallest integer.

For example:
Given [34, 15, 88, 2] your solution will return 2
Given [34, -345, -1, 100] your solution will return -345
You can assume, for the purpose of this kata, that the supplied array will not be empty.
*/

    public static int findSmallestInt(int[] args) {

        int min = args[0];

        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        System.out.println(min);
        return min;
    }


/*
 Very simple, given a number (integer / decimal / both depending on the language),
 find its opposite (additive inverse).
 */

    public static int opposite(int number) {
        return number - number * 2;
    }


    /*
    Messi is a soccer player with goals in three leagues:
    LaLiga, Copa del Rey, Champions
    Complete the function to return his total number of goals in all three leagues.
    Note: the input will always be valid.
    */
    public static int goals(int laLigaGoals, int copaDelReyGoals, int championsLeagueGoals) {
        int goals = laLigaGoals + copaDelReyGoals + championsLeagueGoals;
        return goals;

    }

}