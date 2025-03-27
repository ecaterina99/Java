
public class BinarySearchTree {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        bt.insert(new Node(2));
        bt.insert(new Node(8));
        bt.insert(new Node(1));
        bt.insert(new Node(4));
        bt.insert(new Node(9));
        bt.insert(new Node(25));
        bt.display();

        System.out.println(bt.search(25));
        bt.remove(4);

        bt.display();
    }
}