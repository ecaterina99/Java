class LinkedListCreation {
    // head of list
    Node head;

    public static void main(String[] args) {
        LinkedListCreation list = new LinkedListCreation();

        // Insert 6. So linked list becomes 6->NUllist
        list.append(6);

        list.push(4);

        // Insert 7 at the beginning. So linked list becomes 7->6->NUllist

        // Insert 1 at the beginning. So linked list becomes 1->7->6->NUllist
        list.push(1);

        // Insert 4 at the end.So linked list becomes 1->7->6->4->NUllist
        list.append(9);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NUllist
        list.insertAfter(list.head.next, 8);
        list.insertAfter(list.head.next.next.next, 5);
        list.insertAfter(list.head,11);
        list.insertAfter(list.head.next.next.next.next.next.next.next,181);


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
        //Allocate the Node & Put in the data
        Node newNode = new Node(newData);

        //Make next of new Node as head
        newNode.next = head;

        //Move the head to point to new Node
        head = newNode;
    }

    // Inserts a new node after the given prev_node.
    public void insertAfter(Node prev_node, int new_data) {
        //  Check if the given Node is null
        if (prev_node == null) {
            System.out.println(
                    "The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);

        //Make next of new Node as next of prev_node
        new_node.next = prev_node.next;

        //make next of prev_node as new_node
        prev_node.next = new_node;
    }

    // Appends a new node at the end. This method is defined inside LinkedList class shown above
    public void append(int new_data) {
        /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty, then make the new node as head */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        /* 4. This new node is going to be  the last node, so make next of it as null */
        new_node.next = null;

        // 5. Else traverse till the last node
        Node last = head;
        while (last.next != null)
            last = last.next;

        // 6. Change the next of last node
        last.next = new_node;
        return;
    }

    // This function prints contents of linked list starting from the given node
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

}
