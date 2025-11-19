public class DoubleLinkedList {
    Node head;
    Node tail;

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();
        list.push(5);
        list.push(10);
        list.push(15);
        list.append(55);
        list.push(10);
        list.append(118);
        list.insertAfter(99, 10);
        list.deleteNode(10);
        list.append(47);
        list.print();
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAfter(int data, int key) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node node = getNode(key);
        if (node == null) {
            System.out.println("Node with value " + key + " is not found.");
            return;
        }
        Node newNode = new Node(data);
        insertAfterNode(node, newNode);

    }

    public void insertAfterNode(Node node, Node newNode) {
        newNode.next = node.next;
        newNode.prev = node;

        if (node.next != null) {
            node.next.prev = newNode;
        } else {
            tail = newNode;
        }
        node.next = newNode;
    }

    private Node getNode(int key) {
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        return temp;
    }

    public void deleteNode(int key) {
        Node temp = getNode(key);
        if (temp == null) {
            System.out.println("Node with value " + key + " is not found.");
            return;
        }

        if (temp == head) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }

        if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
}