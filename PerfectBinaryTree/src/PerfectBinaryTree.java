/*
A perfect binary tree is a binary tree in which all interior nodes have two
children and all leaves have the same depth or same level.
You are given a class called TreeNode. Implement the method isPerfect which
determines if a given tree denoted by its root node is perfect.
 */
public class PerfectBinaryTree {

    public static int findDepth(Node node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    public static boolean isPerfect(Node root, int depth, int level) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return (depth == level + 1);
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        return isPerfect(root.left, depth, level + 1) && isPerfect(root.right, depth, level + 1);
    }


    public static boolean checkPerfectTree(Node root) {
        int depth = findDepth(root);
        return isPerfect(root, depth, 0);
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The depth is: " + findDepth(root));
        System.out.println("Is it perfect ? " + checkPerfectTree(root));
    }
}