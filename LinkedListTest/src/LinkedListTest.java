import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //like Stack
        list.push("A");
        list.push("B");
        list.push("C");
        list.push("D");
        list.push("E");
        System.out.println(list);

        LinkedList<String> list2 = new LinkedList<>();
        //like Queue
        list2.offer("A");
        list2.offer("B");
        list2.offer("C");
        list2.offer("D");
        list2.offer("E");
        System.out.println(list2);


        list2.add(4,"0");
        System.out.println(list2);
        list2.remove(4);
        System.out.println(list2);

        System.out.println(list2.peekFirst());
        System.out.println(list2.peekLast());
        System.out.println(list2);
        list2.removeFirst();
        list2.removeLast();
        System.out.println(list2);

        list2.offer("A");
        list2.offer("Z");2);
        System.out.println(list
        System.out.println(get(1));

    }
}