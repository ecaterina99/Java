/**
 * In this kata you are required to, given a string, replace every letter with its position in the alphabet.
 * If anything in the text isn't a letter, ignore it and don't return it
 */
void main() {
    String text = "Z91wY7oIV9wUJY&2>.8NR)f?K{Y\n" +
            "23 25 15 9 22 23 21 10 25 14 18 6 11 25";
    text = text.toLowerCase();
    int cnt = 1;
    Map<Character, Integer> map = new HashMap<>();
    for (char i = 'a'; i <= 'z'; i++) {
        map.put(i, cnt++);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = text.charAt(i);
            if (entry.getKey() == c) {
                sb.append(entry.getValue()).append(" ");
            }
        }
    }
    if (!sb.isEmpty()) {
        sb.replace(sb.length() - 1, sb.length(), "");
    }
    String result = sb.toString();
    System.out.println(result);
}
