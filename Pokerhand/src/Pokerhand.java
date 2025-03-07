/*
Your task is to determine if the cards in the list makes up a straight (five cards of sequential rank) or not.
The cards will always have values ranging from 2-14, where 14 is the ace.
Be aware that the ace (14) also should count as value 1!
The number of cards will vary, but will never be more than 7 (the board (5) + player hand (2))
 */

import java.util.ArrayList;
import java.util.Collections;

public class Pokerhand {
    public static void main(String[] args) {
        ArrayList<Integer> cards = new ArrayList<>();
        cards.add(2);
        cards.add(3);
        cards.add(4);
        cards.add(11);
        cards.add(12);
        cards.add(13);



        boolean result = false;
        if (cards.size() < 5) {
            result = false;
        }

        Collections.sort(cards);
        System.out.println(cards);
        int cnt = 0;

        for (int i = 0; i < cards.size() - 3; i++) {

            if (cards.get(i) == cards.get(i + 1) - 1 && cards.get(i + 1) - 1 == cards.get(i + 2) - 2 && cards.get(i + 2) - 2 == cards.get(i + 3) - 3) {
                cnt++;
            }
        }

        if (cards.contains(14) && cards.contains(2)) {
            cnt++;
        }

        if (cnt >= 2) {
            result = true;
        } else {
            result = false;
        }

        System.out.println("Is it Pokerhand? " + result);
    }
}




