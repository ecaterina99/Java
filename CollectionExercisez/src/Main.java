//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * 1)Write a Java method that reverses a given string "Hello"
 * 2)Write a Java method that checks whether a given string is a palindrome.(Madam)
 * 3)Remove Duplicates from a List
 * 4)Given a list of strings, count how many times each word appears.
 * 5)Given a list of integers, return a list that contains only even numbers.
 * 6)You are given a list of orders. Each order contains a product name and a quantity.
 * Write a method that calculates the total quantity for each product.
 *
 */
void main() {
    //1
    String word = "Hello";
    String[] arr = word.split("");
    StringBuilder result = new StringBuilder();
    for (int i = arr.length - 1; i >= 0; i--) {
        result.append(arr[i]);
    }
    System.out.println(result);

    //2
    String palindrome = "madam";
    String[] arr2 = palindrome.split("");
    StringBuilder reverse = new StringBuilder();

    for (int i = arr2.length - 1; i >= 0; i--) {
        reverse.append(arr2[i]);
    }
    String res = reverse.toString();
    System.out.println(res.equals(palindrome));

    //3
    List<Integer> original = List.of(1, 2, 3, 2, 4, 1);
    HashSet<Integer> distinct = new HashSet<>(original);
    System.out.println(distinct.toString());

    //4
    List<String> fruits = List.of("apple", "banana", "apple", "orange", "banana");
    Map<String, Integer> dist = new HashMap<>();
    for (String fr : fruits) {
        dist.put(fr, dist.getOrDefault(fr, 0) + 1);
    }
    dist.forEach((key, value) -> System.out.println(key + " " + value));


    //5
    List<Integer> all = List.of(1, 2, 3, 4, 5, 6);
    List<Integer> even = new ArrayList<>();

    for (Integer integer : all) {
        if (integer % 2 == 0) {
            even.add(integer);
        }
    }
    for (Integer integer : even) {
        System.out.println(integer);
    }

    //6

    Order first = new Order(2, "laptop");
    Order second = new Order(3, "phone");
    Order third = new Order(3, "laptop");

    List<Order> orders = new ArrayList<>();
    orders.add(first);
    orders.add(second);
    orders.add(third);

    Map<String, Integer> map = new HashMap<>();

    for (Order order : orders) {

        String product = order.getProduct();
        int quantity = order.getQuantity();

        if (map.containsKey(product)) {
            map.put(product, map.get(product) + quantity);
        } else {
            map.put(product, quantity);
        }
    }

    map.forEach((key, value) -> System.out.println(key + " -> " + value));

}


