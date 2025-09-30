/*
In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G".
Your function receives one side of the DNA (string, except for Haskell);
you need to return the other complementary side.
DNA strand is never empty or there is no DNA at all (again, except for Haskell).
 */

public class Main {
    public static void main(String[] args) {
        String dna = "TAACG";
        StringBuilder complement = new StringBuilder();

        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'A') {
                complement.append('T');
            } else if (dna.charAt(i) == 'C') {
                complement.append('G');
            } else if (dna.charAt(i) == 'G') {
                complement.append('C');
            } else if (dna.charAt(i) == 'T') {
                complement.append('A');
            }
        }
        String res = complement.toString();
        System.out.println(res);

    }
}