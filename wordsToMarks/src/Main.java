/**
 * Write a function which calculates the value of a word based off the sum of the alphabet positions of its characters.
 * The input will always be made of only lowercase letters and will never be empty.
 */
void main() {
    String text = "attitude";
    int cnt = 1;
    int sum = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (char ch = 'a'; ch <= 'z'; ++ch) {
        map.put(ch, cnt++);
    }

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);
            if (entry.getKey().equals(a)) {
                sum = sum + entry.getValue();
            }
        }
    }
    System.out.println(sum);
}
