public class CircularDoublyLinkedList {
    private Node head;


        public static void main(String[] args) {
            CircularDoublyLinkedList list = new CircularDoublyLinkedList();
            list.insert(1);
            list.insert(2);
            list.insert(3);
            list.insert(4);
            list.insert(5);

            System.out.println(" Circular doubly linked list: ");
            list.display();

            list.delete(3);
            list.display();
        }


    class Node {
        int data;
        private Node next, prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void delete(int key) {
        if (head == null) return;

        Node temp = head, prevNode = null;

        while (temp.data != key) {
            if (temp.next == head) {
                System.out.println("The element is not in the list");
                return;
            }
            prevNode = temp;
            temp = temp.next;
        }

        if (temp == head && temp.next == head) { //if there is only one node
            head = null;
        } else if (temp == head) { // delete the head
            head = head.next;
            head.prev = temp.prev;
            temp.prev.next = head;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }
}
