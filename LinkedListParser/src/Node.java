final class Node {
    public final int data;
    public Node next;
    public Node(int data) {
        this(data, null);
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}