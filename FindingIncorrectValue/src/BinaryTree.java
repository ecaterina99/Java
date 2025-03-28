

public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void createTree() {
        root = new Node(27);
        root.left = new Node(13);
        root.right = new Node(15);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(9);
    }

    //postorder traversal (left--right--root)
    public void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    private boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    public int sumOfLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return node.data;
        }
        return sumOfLeaves(node.left) + sumOfLeaves(node.right);
    }

    public int sumOfLeftLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return node.data;
        }
        return sumOfLeftLeaves(node.left)+sumOfLeftLeaves(node.left.right);
    }
    public int sumOfRightLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return node.data;
        }
        return sumOfRightLeaves(node.right)+sumOfRightLeaves(node.right.left);
    }

   public void findIncorrectNumber(Node node) {

        if(root.right.data==sumOfRightLeaves(node)){
            System.out.println("Right leaves are ok");

        }
        else {
            System.out.println("Sum of right leaves are not ok");
            System.out.println("The problem is in: "+root.right.data);
        }
        if(root.left.data==sumOfLeftLeaves(node)){
            System.out.println("Sum of left leaves is ok");
        }
        else {
            System.out.println("Sum of left leaves are not ok");
            System.out.println("The problem is in: "+root.left.data);
        }
        if(root.left.data==sumOfLeftLeaves(node) && root.right.data==sumOfRightLeaves(node)){
            if(root.data==sumOfLeaves(node)) {
                System.out.println("Right root and left root is ok");
            }else{
                System.out.println("The main root is not ok");
                System.out.println("The problem is in: "+root.data);

            }
        }
   }



    public int countSum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + countSum(node.left) + countSum(node.right);
    }


    /*
    public int countNodes(Node node){
        if(node == null){
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countTreeHeight(Node node){
        if(node == null){
            return 0;
        }
        int leftHeight = countTreeHeight(node.left);
        int rightHeight = countTreeHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //search the last node in the tree
    private Node findLastNode(Node root){
        if(root == null){
            return null;
        }
        // right last node
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    //delete node
    public Node deleteNode(Node root, int key){
        if(root == null){
            return null;
        }
        if(root.data == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            Node lastNode = findLastNode(root);

            root.data = lastNode.data;
            root = removeLastNode(root);
            return root;
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;

    }

    private Node removeLastNode(Node root){
        if(root == null){
            return null;
        }
        //if the key is a leaf
        if(root.left == null && root.right == null){
            return null;
        }
        if(root.right != null){
            root.right = removeLastNode(root.right);
        }
        else{
            root.left = removeLastNode(root.left);
        }
        return root;
    }


     */

}
