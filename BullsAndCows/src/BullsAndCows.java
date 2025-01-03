/*
The computer generates a secret number consisting of 4 distinct digits.
Then the player, in 8 turns, tries to guess the number. As a result he receives from the computer
the number of matches. If the matching digits are in their right positions, they are "bulls",
if in different positions, they are "cows".

To implement this you will use:
1)a constructor (int) - initiates the game, receives a number and then sets it as the secret number.
2)and a function "compare with (int)" - compares the given and the secret numbers and then
returns a String formated as "X bull/bulls and Y cow/cows".

However, there are some notes:
1)if the given number matches the secret number instead of returning "4 bulls and 0 cows", return "You win!"
Any next attempts to play the game (even with invalid numbers) should return "You already won!"
2)if the amount of turns in this game is more than 8 (invalid turns are not counted)
the returned String should be "Sorry, you're out of turns!".
3)After checking the turns you should validate the given number.
If it does not correspond to the conditions you should throw an exception : IllegalArgumentException
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BullsAndCows {

    private final int[] secretDigits = new int[4];
    private int turns;
    boolean gameWon = false;
    String result = "";
    private int inputNumber;


    public BullsAndCows(int secretNumber) {
        if (secretNumber < 1000 || secretNumber > 9999) {
            throw new IllegalArgumentException();
        }

        String numberStr = String.valueOf(secretNumber);
        Set<Character> charSet = new HashSet<>();
        for (char c : numberStr.toCharArray()) {
            if (!charSet.add(c)) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 3; i >= 0; i--) {
            this.secretDigits[i] = secretNumber % 10;
            secretNumber = secretNumber / 10;
        }

    }

    public String compareWith(int inputNumber) {
        this.turns++;
        if (gameWon) {
            this.turns--;
            return "You already won!";

        } else if (turns > 8) {
            return "Sorry, you're out of turns!";

        } else if (inputNumber < 1000 || inputNumber > 9999) {
            this.turns--;
            throw new IllegalArgumentException();
        }

        System.out.println("Secret digits are: " + Arrays.toString(secretDigits));


        //input digits
        int[] inputDigits = new int[4];
        for (int j = 3; j >= 0; j--) {
            inputDigits[j] = inputNumber % 10;
            inputNumber = inputNumber / 10;
        }
        System.out.println("Input digits are: " + Arrays.toString(inputDigits));

        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 4; j++){
                if (inputDigits[j] == inputDigits[i]){
                    throw new IllegalArgumentException();
                }
            }
        }

        // bulls & cows
        int cntBulls = 0;
        int cntCows = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.secretDigits[i] == inputDigits[j] && i == j) {
                    cntBulls++;
                } else if (this.secretDigits[i] == inputDigits[j] && i != j) {
                    cntCows++;
                }
            }
        }
        if (cntBulls == 4) {
            gameWon = true;
            System.out.println("You win!");
            return "You win!";
        }
        System.out.println("Bulls: " + cntBulls);
        System.out.println("Cows: " + cntCows);

        if (cntBulls == 1 && cntCows != 1) {
            result = cntBulls + " " + "bull " + "and " + cntCows + " cows";
        } else if (cntCows == 1 && cntBulls != 1) {
            result = cntBulls + " " + "bulls " + "and " + cntCows + " cow";
        } else if (cntBulls == 1 && cntCows == 1) {
            result = cntBulls + " " + "bull " + "and " + cntCows + " cow";
        } else {
            result = cntBulls + " " + "bulls " + "and " + cntCows + " cows";
        }
        System.out.println("The result is: " + result);
        return result;
    }
}