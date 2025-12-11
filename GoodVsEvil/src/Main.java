import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.awt.SystemColor.text;

public class Main {
    public static void main(String[] args) {

        String goodAmounts="4418 93 173 703 1858 5754";
        String evilAmounts="8341 4598 6925 2199 2792 3835 402";
        String output = "";
        int sumForGood = 0;
        int sumForEvil=0;

        List<Integer> good = new ArrayList<>();
        List<Integer> evil = new ArrayList<>();

        Matcher matcher = Pattern.compile("-?\\d+").matcher(goodAmounts);
        while (matcher.find()) {
            good.add(Integer.parseInt(matcher.group()));
        }

        matcher= Pattern.compile("-?\\d+").matcher(evilAmounts);
        while (matcher.find()) {
            evil.add(Integer.parseInt(matcher.group()));
        }

        for (Integer number : good) {
            sumForGood += number;
        }
        for (Integer number : evil) {
            sumForEvil += number;
        }

        if(sumForGood > sumForEvil){
            output = "Battle Result: Good triumphs over Evil";
        }else if(sumForGood < sumForEvil){
            output = "Battle Result: Evil eradicates all trace of Good";
        }else{
            output = "Battle Result: No victor on this battle field";
        }

      System.out.println(output);

    }
}