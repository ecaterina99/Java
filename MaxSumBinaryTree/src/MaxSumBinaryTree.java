/*
You are given a binary tree. Implement a function that returns the maximum sum of a route from root to leaf.
Return 0 if the tree is empty.
Please note that you are not to find the best possible route in the tree,
but the best possible route from root to leaf, e.g. for the following tree,
you cannot skip the leaves and return 5 + 10 = 15: the expected answer is 5 + 4 + -60 = -51
 */


class MaxSumBinaryTree {
    static int maxSum(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.right == null) {
            return root.value + maxSum(root.left);
        }
        if (root.left == null) {
            return root.value + maxSum(root.right);
        }

        return root.value + Math.max(maxSum(root.left), maxSum(root.right));
    }
}