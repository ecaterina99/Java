/*
Cele patru simboluri standard în cărţi sunt TREFLĂ, CARO, CUPĂ şi PICĂ.
Trebuie să creaţi un program care să-i permită utilizatorului să introducă numele simbolului şi,
la rândul său, să obţină simbolul. Când implementaţi programul, trebuie să utilizaţi enumerări.
 */

import java.util.Scanner;

public class PlayingCards {
    public static void main(String[] args) {

        for (Suit suit : Suit.values()) {
            System.out.print(suit.ordinal() + ": " + suit.name() + "\n");
        }

        System.out.print("Enter the card suit: ");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Your suit is : ");
            Suit suit = Suit.valueOf(Suit.class, sc.nextLine().toUpperCase());
            switch (suit) {
                case CLUBS:
                    System.out.println("CLUBS");
                    break;
                case DIAMONDS:
                    System.out.println("DIAMONDS");
                    break;
                case HEARTS:
                    System.out.println("HEARTS");
                    break;
                case SPADES:
                    System.out.println("SPADES");
                    break;
            }
        } catch (Exception exc) {
            System.out.println("There is an error.");
        }
    }
}