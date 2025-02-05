/*
Complete the solution so that the function will break up camel casing, using a space
between words.
Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""
 */

public class SplitByUppercase {
    public static void main(String[] args) {
        String s = "camelCasingBox";
        String regex = "(?=\\p{Upper})";
        String[] myArray = s.split(regex);

        String stringWithSpaces = "";
        for(String word : myArray) {
            stringWithSpaces = stringWithSpaces + word + " ";
        }
        System.out.println(stringWithSpaces);
        if (stringWithSpaces.endsWith(" ")) {
            System.out.println(stringWithSpaces.substring(0, stringWithSpaces.length() - 1) );
        }
    }
}
