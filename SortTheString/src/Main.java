import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String word = "4of Fo1r pe6ople g3ood th5e the2";
        String order = "";
        StringTokenizer tokenizer = new StringTokenizer(word, " ");
        int tokenCount = tokenizer.countTokens();
        String[] stringArray = new String[tokenCount];

        Map<Integer, String> hashMap = new HashMap<>();

        ArrayList<String> result = new ArrayList<>();

        int number;


        if (word == "") {
            System.out.println(order);
        } else {

            for (int i = 0; i < tokenCount; i++) {
                stringArray[i] = tokenizer.nextToken();
            }

            for (String element : stringArray) {
                number = Integer.parseInt(element.replaceAll("[^0-9]", ""));
                hashMap.put(number, element);
            }

            for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
                result.add(entry.getValue());
            }

            order = String.join(" ", result);
            System.out.println(order);

        }

    }
}

