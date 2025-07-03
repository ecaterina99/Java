

/*
You have to assume that n people are put into a circle and that they are eliminated in steps of k element
 */

public class JosephusSurvivor {
    public static void main(String[] args) {
        final int n = 7;
        final int k = 2;
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.print();
        System.out.println(list.count());
        list.findSurvivor(k);

    }

    public static class LinkedList {
         Node head;

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

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                newNode.next = head;
                newNode.prev = head;
                return;
            }
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
            newNode.next = head;

        }

        public void print() {
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            }
            while (current != head);
            System.out.println();

        }

        public int count() {
            Node current = head;
            int count = 0;
            do {
                current = current.next;
                count++;
            }
            while (current != head);
            return count;
        }


        public void findSurvivor(int k) {
            Node current = head;

            int size = count();

            while (size > 1) {
                for (int i = 0; i < k - 1; i++) {
                    current = current.next;
                }
                System.out.println("Removing--->" + current.data);

                current.prev.next = current.next;
                current.next.prev = current.prev;
                current = current.next;
                size--;
            }
            System.out.println("Surviver-->" + current.data);

        }
    }
}


/*
import java.util.Arrays;

public class JosephusSurvivor {

  public static int josephusSurvivor(int n, final int k) {
    LinkedList list = new LinkedList();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

    list.print();

        LinkedList.Node current = list.head;

        while (n > 1) {
            for (int i = 0; i < k - 1; i++) {
                current = current.next;
            }

            System.out.println("Removing---> " + current.data);

            current = list.remove(current);

            n--;
        }
            return current.data;
  }
}

 class LinkedList {
        Node head;

            static class Node {
                int data;
                Node next;
                Node prev;

                public Node(int data) {
                    this.data = data;
                    this.next = null;
                    this.prev = null;
                }
            }

    public void print() {
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            }
            while (current != head);
            System.out.println();

        }

     public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
            newNode.next = head;
            head.prev = newNode;
        }
       }
         public Node remove(Node node) {
        if (node == head && node.next == head) {
            head = null;
            return null;
        }

        if (node == head) {
            head = node.next;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        return node.next;
    }
    }

 */







