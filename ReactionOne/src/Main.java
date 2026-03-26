/**
 * Find all integers between m and n (m and n are integers with 1 <= m <= n)
 * such that the sum of their squared divisors is itself a square.
 * Find all its divisors
 * Square each divisor
 * Add those squares
 * Check:Is that sum a perfect square?
 * If YES → include that number in the result.
 */
void main() {
    long m = 42;
    long n = 250;

    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (long i = m; i <= n; i++) {
        int sum = findSum(i);
        int sqrt = (int) Math.sqrt(sum);

        if ((long) sqrt * sqrt == sum) {
            sb.append("[").append(i).append(", ").append(sum).append("]").append(", ");
        }
    }
    sb.replace(sb.length() - 2, sb.length(), "");
    sb.append("]");
    String result = sb.toString();
    System.out.println(result);
}

public int findSum(long m) {
    ArrayList<Integer> divisors = new ArrayList<>();
    ArrayList<Integer> squares = new ArrayList<>();

    for (int i = 1; i <= m; i++) {
        double number = (double) m / (double) i;
        if (number % 1 == 0) {
            divisors.add(i);
        }
    }
    for (Integer i : divisors) {
        squares.add(i * i);
    }

    int sum = 0;

    for (Integer square : squares) {
        sum = sum + square;
    }
    return sum;
}

