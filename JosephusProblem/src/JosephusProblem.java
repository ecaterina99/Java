public class JosephusProblem {
    private Node head;

    public static void main(String[] args) {


        JosephusProblem circle = new JosephusProblem();

        circle.insert(1);
        circle.insert(2);//
        circle.insert(3);
        circle.insert(4);///
        circle.insert(5);
        circle.insert(6);//
        circle.insert(7);
        circle.display();
        System.out.println("Total numbers: " + circle.countNodes());
        int step = 2;
        circle.deleteSequentially(step);


    }

    class Node {
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

    public void delete(int key) {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        Node current = head;
        while (current.data != key) {
            if (current.next == head) {
                System.out.println("The element is not in the list");
                return;
            }
            current = current.next;
        }
        if (current == head && current.next == head) {
            head = null;
        } else if (current == head) {
            head = head.next;
            head.prev = head.next;
            current.prev.next = head;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
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

    public void deleteSequentially(int step) {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        Node current = head;
        int currentPosition = 0;
            do {
                currentPosition++;
                current = current.next;
                if(currentPosition % step == 0) {
                    System.out.print(current.data + " ");
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            while (current.next != current.prev);



        }
    }

