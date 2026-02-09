/**
 * Using streams:
 * Split text into words
 * Convert to lowercase
 * Count how many times each word appears
 * Return result as:
 * Map<String, Long>
 */

void main() {
    String text = "Java streams are powerful and streams are fun and java is cool";
    List<String> words = Arrays.stream(text.split("\\s+")).map(w -> w.toLowerCase()).toList();
    Map<String, Long> counts = words.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
    System.out.println(counts);
}
