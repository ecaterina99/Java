
/*Complete the function that accepts a string parameter,
and reverses each word in the string. All spaces in the string should be retained.
 */

public class Main {
    public static void main(String[] args) {
        String original="This is an example!";
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char c : original.toCharArray()) {
            if (c == ' ') {
                result.append(word.reverse());
                word.setLength(0);
                result.append(c);
            }
            else {
                word.append(c);
            }
        }
        result.append(word.reverse());

System.out.println(result.toString());
    }
}