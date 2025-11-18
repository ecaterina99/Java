public class LinkedList {

    Node head;

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.push(5);
        list.push(4);
        list.push(3);
        list.append(8);
        list.insert(111, list.head);
        list.insertAfter(55, 111);
        list.delete(3);
        list.delete(4);

        list.printList();

    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void append(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public void insert(int data, Node target) {
        if (target == null) {
            System.out.println("Linked list is empty");
            return;
        }

        Node node = new Node(data);
        node.next = target.next;
        target.next = node;
    }

    public void insertAfter(int data, int target) {
        Node node = new Node(data);
        Node current = head;
        while (current != null && current.data != target) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("The node does not exist");
        }

        node.next = current.next;
        current.next = node;

    }


    public void delete(int data) {
        Node current = head;
        Node prev = null;
        if (current == null) {
            System.out.println("The list is empty");
            return;
        }
        if (current != null && current.data == data) {
            head = current.next;
            return;
        }
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with value " + data + " not found.");
            return;
        }
        prev.next = current.next;

    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}