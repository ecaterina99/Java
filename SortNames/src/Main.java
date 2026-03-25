/**
 * Make a program that:
 * -makes this string uppercase
 * -gives it sorted in alphabetical order by last name.
 * When the last names are the same, sort them by first name.
 * Last name and first name of a guest come in the result between parentheses separated by a comma.
 * Res: "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)"
 */

void main() {
    String s = "Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn";
    List<String> names = List.of(s.split(";"));

    Map<String, String> fullName = new HashMap<>();
    for (String n : names) {
        String[] parts = n.split(":");
        String firstName = parts[0].toUpperCase();
        String lastName = parts[1].toUpperCase();
        fullName.put(firstName, lastName);
    }

    Map<String, String> sorted = fullName.entrySet()
            .stream()
            .sorted(
                    Map.Entry.<String, String>comparingByValue()
                            .thenComparing(Map.Entry::getKey))
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (a, b) -> a,
                    LinkedHashMap::new
            ));

    StringBuilder sb = new StringBuilder();

    for (Map.Entry<String, String> entry : sorted.entrySet()) {
        sb.append("(").append(entry.getValue()).append(", ").append(entry.getKey()).append(")");
    }
    String result = sb.toString();
    System.out.println(result);
}
