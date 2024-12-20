/*
Complete the solution so that it returns true if the first argument(string) passed in ends with
the 2nd argument (also a string).
Examples:
solution('abc', 'bc') // returns true
solution('abc', 'd') // returns false
 */

public class BooleanSolution {
    public static boolean solution(String str, String ending) {
        boolean result = true;

        int endingLength = ending.length();
        int strLength = str.length();

        // 1 case:
        if (endingLength > strLength) {
            result = false;
            return result;
        }

        // 2 case:
        int diffLength = strLength - endingLength;

        for (int i = endingLength - 1; i >= 0; i--) {

            if (ending.charAt(i) != str.charAt(diffLength + i)) {
                result = false;
            }
        }

        return result;
    }
}
