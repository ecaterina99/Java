class LinkedListCreation {
    Node head;

    public static void main(String[] args) {
        LinkedListCreation lc = new LinkedListCreation();
        lc.push(5);
        lc.push(6);
        lc.append(9);
        lc.append(18);
        lc.insert(lc.head, 10);
        lc.insertAfter(9, 55);
        lc.push(100);
        lc.append(115);


        lc.print();
        lc.insertAfter(111, 55);

    }

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void append(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void insert(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void insertAfter(int target, int newData) {
        Node newNode = new Node(newData);
        Node current = head;
        while (current != null && current.data != target) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("The node does not exist");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;

    }

    public void delete(int key) {
        Node temp = head, prev = null;
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
        }

        // Case 1: If the head node must be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        //Case 2: Search for the key
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        //If key was not found in the list
        if (temp == null) {
            System.out.println("Node with value " + key + " not found.");
            return;
        }
        //Delete the node from the list
        prev.next = temp.next;

    }

    public void print() {
        Node node = head;
        System.out.print("Linked list: ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}




























/*class LinkedListCreation {
    // head of list
    Node head;

    public static void main(String[] args) {
        LinkedListCreation list = new LinkedListCreation();

        // Insert 6. So linked list becomes 6->NUllist
        list.append(6);

        // Insert 7 at the beginning. So linked list becomes 7->6->NUllist
        list.push(7);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->NUllist
        list.push(1);

        // Insert 9 at the end.So linked list becomes 1->7->6->9->NUllist
        list.append(9);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NUllist
        list.insertAfter(list.head.next, 8);
        list.insertAfter(list.head.next.next.next, 5);
        list.insertAfter(list.head, 11);
        list.insertAfter(list.head.next.next.next.next.next.next.next, 181);

        System.out.println(
                "Created Linked list is: ");
        list.printList();
    }

    // Linked list Node
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Inserts a new Node at front of the list.
    public void push(int newData) {

        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // Inserts a new node after the given prev_node.
    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println(
                    "The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Appends a new node at the end. This method is defined inside LinkedList class shown above
    public void append(int newData) {

        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null)
            last = last.next;

        // 6. Change the next of last node
        last.next = newNode;
        return;
    }

    // This function prints contents of linked list starting from the given node
    public void printList() {
        Node eachNode = head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.next;
        }
    }

}
*/