import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String word = "Java";
        word = word.toLowerCase();
        String encode;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new LinkedHashMap<>();
        ArrayList <Character> duplicates = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        for(int i=0; i < word.length(); i++) {
                if(duplicates.contains(word.charAt(i))) {
                    sb.append(")");
                }else{
                    sb.append("(");
                }
            }
        encode = sb.toString();
        System.out.println(encode);
    }
}