import java.util.HashMap;
import java.util.*;

public class CountCharactersInString {
    public static void main(String[] args) {

        String str = "Ecaterina";
        characterCount(str);

    }

    static void characterCount(String str) {
        HashMap<Character, Integer> charCountMap
                = new HashMap<Character, Integer>();

        char[] strArray = str.toCharArray();
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {

                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
            for (Map.Entry entry : charCountMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}