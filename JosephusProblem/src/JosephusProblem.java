public class JosephusProblem {

    public static void main(String[] args) {

        LinkedList circle = new LinkedList();
        int step = 2;
        circle.insert(1);
        circle.insert(2);
        circle.insert(3);
        circle.insert(4);
        circle.insert(5);
        circle.insert(6);
        circle.insert(7);

        circle.display();
        System.out.println("Total numbers: " + circle.countNodes());
        System.out.println("Last remaining: ");
        circle.delete(step);
    }

    public static class LinkedList {
        private Node head;

        public class Node {
            int data;
            Node next;
            Node prev;

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
                newNode.prev = head;
                newNode.next = head;
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
                System.out.println("The list is empty!");
                return;
            }
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
            System.out.println();
        }

        public int countNodes() {
            if (head == null) {
                return 0;
            }
            int count = 0;
            Node current = head;
            do {
                current = current.next;
                count++;
            } while (current != head);
            return count;
        }

        public void delete(int step) {
            if (head == null) return;

            Node current = head;
            int size = countNodes();

            while (size > 1) {
                for (int i = 0; i < step - 1; i++) {
                    current = current.next;
                }

                System.out.println("Removing: " + current.data);

                //only 1 node in the list
                if (current.next == current) {
                    head = null;
                    return;
                }

                // delete node
                current.prev.next = current.next;
                current.next.prev = current.prev;

                // delete head
                if (current == head) {
                    head = current.next;
                }

                current = current.next;
                size--;
            }

            System.out.println("The winner: " + current.data);
        }

    }
}

