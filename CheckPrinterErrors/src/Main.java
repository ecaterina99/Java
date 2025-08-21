
public class Main {
    public static void main(String[] args) {

        String s = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        int numberOfAllLetters = s.length();
        int numberOfErrors = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 'm') {
                numberOfErrors++;
            }
        }

        StringBuilder sb = new StringBuilder();

        String result;
        result = sb.append(numberOfErrors).append("/").append(numberOfAllLetters).toString();
        System.out.println(result);

    }
}