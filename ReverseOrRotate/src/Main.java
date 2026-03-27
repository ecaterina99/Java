/**
 * The input is a string. Cut the string into chunks (a chunk here is a substring of the initial string)
 * of size sz (ignore the last chunk if its size is less than sz).
 * If the sum of a chunk's digits is divisible by 2, reverse that chunk;
 * otherwise rotate it to the left by one position.
 * Put together these modified chunks and return the result as a string.
 * if sz is <= 0 or if str == "" return ""
 * sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return ""
 * ex: ("66443875", 4) --> "44668753"
 * <p>
 * 1)divide a string by sz;
 * 2)check if sum is odd or even;
 * 3)if it's odd -> rotate to the left by one position;
 * 4)if it's even -> reverse;
 * 5)return concat string;
 */
void main() {
    String str = "66443875";
    int sz = 4;
    String res;

    if (str.isEmpty() || sz <= 0 || sz > str.length()) {
        res = "";
    }
    else {

        String first = str.substring(0, sz);
        String second = str.substring(sz, str.length());
        System.out.println(first + " " + second);

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < first.length(); i++) {
            int n = Character.getNumericValue(first.charAt(i));
            sum1 = sum1 + n;
        }

        for (int j = 0; j < second.length(); j++) {
            int n = Character.getNumericValue(second.charAt(j));
            sum2 = sum2 + n;
        }

        System.out.println(sum1 + " " + sum2);

        StringBuilder sb = new StringBuilder();

        if (sum1 % 2 == 0) {
            for (int i = first.length() - 1; i >= 0; i--) {
                char c = first.charAt(i);
                sb.append(c);
            }
        } else {
            sb.append(first.substring(1, first.length())).append(first.substring(0, 1));
        }

        if (sum2 % 2 == 0) {
            for (int i = second.length() - 1; i >= 0; i--) {
                char c = second.charAt(i);
                sb.append(c);
            }
        } else {
            sb.append(second.substring(1, second.length())).append(second.substring(0, 1));
        }
        res = sb.toString();
    }
    System.out.println(res);

}
