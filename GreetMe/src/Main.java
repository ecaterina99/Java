/**
 * Write a method that takes one argument as name and then greets that name,
 * capitalized and ends with an exclamation point.
 * "riley" --> "Hello Riley!"
 */
void main() {
    String name = "riley";
    String result = "";

    StringBuilder sb = new StringBuilder();
    String first = String.valueOf(name.charAt(0));
    String second = name.substring(1,name.length()).toLowerCase();
    sb.append("Hello ").append(first.toUpperCase()).append(second).append("!");
    result = sb.toString();

    System.out.println(result);

}
