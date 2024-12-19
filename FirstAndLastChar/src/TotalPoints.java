/*
Our team's match results are recorded in a collection of strings.
Each match is represented by a string in the format "x:y", where x is our team's score and
y is our opponents score.
Points are awarded for each match as follows:
if x > y: 3 points (win)
if x < y: 0 points (loss)
if x = y: 1 point (tie)
We need to write a function that takes this collection and returns the number of points our
team (x) got in the championship by the rules given above.
 */


public class TotalPoints {

    public static int points(String[] games) {

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            String currentGame = games[i];
            System.out.println("Current game: " + currentGame);
            char currentResultX = currentGame.charAt(0);
            int x = Character.getNumericValue(currentResultX);
            System.out.println("x: " + x);
            char currentResultY = currentGame.charAt(2);
            int y = Character.getNumericValue(currentResultY);
            System.out.println("y: " + y);

            int numberOfPoints;

            if (x > y) {
                numberOfPoints = 3;
            } else if (x < y) {
                numberOfPoints = 0;
            } else {
                numberOfPoints = 1;
            }

            sum = sum + numberOfPoints;

        }
        return sum;
    }
}