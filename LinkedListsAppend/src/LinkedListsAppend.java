/*
Write an Append() function which appends one linked list to another.
 */

public class LinkedListsAppend {

    public static void main(String[] args) {
        LinkedList listA = new LinkedList();
        listA.push(1);
        listA.push(2);
        listA.push(3);
        listA.display();
        LinkedList listB = new LinkedList();
        listB.push(4);
        listB.push(5);
        listB.push(6);
        listB.display();

        listA.append(listB);

        System.out.print("List A after append: ");
        listA.display();
    }

    public static class LinkedList {
        private Node head;

        public class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public void display() {
            Node current = head;
            System.out.print("Linked list: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void append(LinkedList listB) {
            if (head == null) {
                head = listB.head;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next=listB.head;

        }
    }
}