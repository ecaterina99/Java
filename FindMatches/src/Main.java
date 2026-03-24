
void main() {
    String s = "ortsp";
    char first[] = s.toCharArray();
    Arrays.sort(first);
    List<String> words = List.of(new String[]{"sport", "parrot", "ports", "matey"});
    List<String> grabscrab = new ArrayList<>();

    for (String w : words) {
        char second[] = w.toCharArray();
        Arrays.sort(second);
        Boolean matches = Arrays.equals(first, second);
        if (matches) {
            grabscrab.add(w);
        }
    }
    for (String a : grabscrab) {
        System.out.println(a);
    }
}
