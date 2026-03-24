import java.sql.Array;

/**
 * Write a function that takes a single non-empty string of only lowercase and uppercase ascii letters,
 * and returns an ordered list containing the indices of all capital letters in the string.
 */

void main() {
    ArrayList<Integer> capitals = new ArrayList<>();
    String s = "CodEWaRs";
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isUpperCase(c)) {
            capitals.add(i);
        }
    }
    int[] res = new int[capitals.size()];
    for (int i = 0; i < res.length; i++) {
        res[i] = capitals.get(i);
    }
    for (Integer r : res) {
        System.out.println(r);
    }
}
