/**
 * Given an array of ones and zeroes, convert the equivalent binary value to an integer.
 * Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
 */
void main() {
    List<Integer> binary = List.of(1, 0, 0, 1);
    int result = 0;

    for (int bit : binary) {
        result = result * 2 + bit;
    }
    System.out.println(result);
}
