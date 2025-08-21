/*
Take 2 strings s1 and s2 including only letters from a to z.
Return a new sorted string (alphabetical ascending), the longest possible,
containing distinct letters - each taken only once - coming from s1 or s2.
 */

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String s1="xyaabbbccccdefww";
        String s2="xxxxyyyyabklmopq";
        String result;
        StringBuilder builder = new StringBuilder();
        builder.append(s1).append(s2);

        result =  builder.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(result);

    }
}