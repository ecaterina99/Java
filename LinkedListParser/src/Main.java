import java.util.ArrayList;

/**
 * Create a function parse which accepts exactly one argument string
 * which is a string representation of a linked list. Your function must return the corresponding
 * linked list, constructed from instances of the Node.
 * The string representation of a list has the following format: the value of the node,
 * followed by a whitespace, an arrow and another whitespace (" -> ")
 */
public class Main {
    public static void main(String[] args) {

        String s = "1 -> 2 -> 3";
        System.out.println(parse(s));
    }

    public static Node parse(String s) {
        if (s.equals("null")) {
            return null;
        }

        String[] parts = s.split(" -> ");

        Node head = new Node(Integer.parseInt(parts[0]));
        Node curr = head;
        for (int i = 1; i < parts.length - 1; i++) {
            curr.next = new Node(Integer.parseInt(parts[i]));
            curr = curr.next;
        }
        return head;
    }
}