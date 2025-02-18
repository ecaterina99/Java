public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(5);
        list.insert(8);
        list.insert(2);
        list.insert(9);
        list.print();
        list.delete(5);
        list.print();
        list.delete(2);
        list.print();
        list.insertAfter(8, 15);
        list.print();
        list.push(1);
        list.print();
    }

    class Node {
        int data;
        Node next;

        // Constructor to initialize a node with data
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertAfter(int target, int newData) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node newNode = new Node(newData);
        Node current = head;

        do {
            if (current.data == target) {
                newNode.next = current.next;
                current.next = newNode;

                if (current == tail) {
                    tail = newNode;
                }
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Target does not exist");
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        Node previous = null;

        while (current.next != head) {
            if (current.data == key) {

                if (previous == null) {
                    Node last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = current.next;
                    last.next = head;
                    return;
                } else {
                    previous.next = current.next;

                    if (current == tail) {
                        tail = previous;
                    }
                    return;

                }
            }
            previous = current;
            current = current.next;
        }
        if (current == head && current.data == key) {
            previous.next = head;

            // Update tail if the last node is deleted
            tail = previous;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
        }
        System.out.println("Circular Linked List: ");
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}





/*
public class CircularLinkedList {
    Node head;

    public static void main(String[] args) {
CircularLinkedList list = new CircularLinkedList();
list.append(8);
list.append(5);
list.append(9);
list.append(7);
list.insertAfter(5,18);
list.print();
    }

    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        }
        else {
       Node current = head;
       while (current.next != head) {
           current = current.next;
       }
       current.next = newNode;
       newNode.next = head;

        }
    }

    public void insertAfter(int target, int data) {
        Node newNode = new Node(data);

        if (head == null) {
          System.out.println("List is empty");
            return;
        }
        Node current = head;
        while(current.data != target&&current.next != head) {
            current = current.next;
        }
        if(current.data == target) {
            newNode.next = current.next;
            current.next = newNode;
        }
        else {
            System.out.println("Target does not exist");
        }
    }

    public void print() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        do{
            System.out.print(current.data + "-> ");
            current = current.next;
        }while(current != head);
        System.out.println("(Start)");

    }

}

 */