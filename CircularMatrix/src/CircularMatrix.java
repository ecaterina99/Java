
public class CircularMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
            System.out.println();
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}



     /*   for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();

        }



             for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = matrix[j][matrix.length - 1 - i];
            }
            System.out.println();
        }


      */





    /*public class CircularMatrix {
    private Node head;
    private Node tail;

    public CircularMatrix() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        CircularMatrix list = new CircularMatrix();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);

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
        public void print() {
            int n = 3;
            int m = 3;
            if (head == null) {
                System.out.println("List is empty");
            }
            System.out.println("Circular Linked List: ");
            Node current = head;
            do {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(current.data + " ");
                        current = current.next;
                    }
                    System.out.println();
                }
            } while (current != head);
            System.out.println();
        }
    }

     */

