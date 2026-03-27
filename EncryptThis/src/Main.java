/**
 * Your message is a string containing space separated words.
 * You need to encrypt each word in the message using the following rules:
 * The first letter must be converted to its ASCII code.
 * The second letter must be switched with the last letter
 * ex:"hello world" => "104olle 119drlo"
 */
void main() {
    String text = "A wise old owl lived in an oak";
    StringBuilder sb = new StringBuilder();
    String res;
    ArrayList<String> encrypted = new ArrayList<>();
    if (text == null || text.isEmpty()) {
        res = "";
    }
    String[] words = text.split("\\s+");

    for (int i = 0; i < words.length; i++) {
        if (words[i].length() == 1) {
            char a = words[i].charAt(0);
            int castAscii = (int) a;
            sb.append(castAscii);
        } else {
            char first = words[i].charAt(0);
            int castAscii = (int) first;
            sb.append(castAscii);

            String second = words[i].substring(1, words[i].length());

            if (second.length() < 2) {
                sb.append(second);
            } else if (second.length() == 2) {
                char f = second.charAt(0);
                char l = second.charAt(1);
                sb.append(l).append(f);
            } else {
                char f = second.charAt(0);
                char l = second.charAt(second.length() - 1);
                String middle = second.substring(1, second.length() - 1);
                sb.append(l).append(middle).append(f);
            }
        }
        if (i < words.length - 1) {
            sb.append(" ");
        }
        encrypted.add(sb.toString());
    }

    res = sb.toString();
    System.out.println(res);
}