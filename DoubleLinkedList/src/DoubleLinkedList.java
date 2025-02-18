public class DoubleLinkedList {
    Node head;

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.push(5);
        list.push(8);
        list.print();
        list.append(9);
        list.print();
        list.insert(list.head, 2);
        list.print();
        list.insertAfter(5, 3);
        list.print();
        list.delete(3);
        list.print();

        list.traverseBackward();
    }

    public class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public void insert(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The previous node is null");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
    }

    public void insertAfter(int key, int data) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + key + "is not found.");
            return;
        }
        Node newNode = new Node(data);

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;

    }

    public void delete(int key) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with value " + key + " not found.");
            return;
        }
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        current.next = null;
        current.prev = null;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node node = head;
        System.out.print("Double Linked List: ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }

    public void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        System.out.print("Traverse double Linked List: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();

    }
}