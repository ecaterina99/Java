public class Solution {


    public static int[] findNumber(int[] tree) {
        int[] result = new int[]{0, 0};
        //Flag to track if an incorrect node was found earlier in the tree
        boolean flag = false;

        // Iterate through all internal (non-leaf) nodes
        // The last internal node is at index (tree.length - 1) / 2
        for (int i = 0; i < (tree.length - 1) / 2; i++) {

            int leftIndex = 2 * i + 1;  // Index of left child
            int rightIndex = 2 * i + 2;  // Index of right child
            if (2 * leftIndex + 1 > tree.length - 1) { // Check if the current node is a parent of leaf nodes
                if (tree[leftIndex] + tree[rightIndex] != tree[i]) {
                    // If this is the first error found, assume it's in the right leaf
                    if (!flag) {
                        result[0] = rightIndex;
                        result[1] = tree[i] - tree[leftIndex];
                        break;
                    }
                    // Otherwise, assume the error is in the leaves parent node
                    result[0] = i;
                    result[1] = tree[leftIndex] + tree[rightIndex];
                    break;
                }
            }
            // Check if sum of children is incorrect for a non-leaf node
            if (tree[leftIndex] + tree[rightIndex] != tree[i]) {
                flag = true;
                result[0] = i;
                result[1] = tree[leftIndex] + tree[rightIndex];
            }
        }
        return result;
    }
}



/* public class Solution {


    public static int[] findNumber(int[] tree) {
        int size = tree.length;

        // Determine the size of the tree and its levels

        //Number of levels in Binary Tree: height=log2(size+1)
        //This formula calculates the height of a complete binary tree with size nodes.
        int height = (int) (Math.log(size + 1) / Math.log(2));

        //formula for first leaf index: FirstLeafIndex=(2 in power (height−1))−1
        int firstLeafIndex = (int) Math.pow(2, height - 1) - 1;

        // Create a copy of the tree with correct values
        int[] correctTree = new int[size];

        // First, copy the leaf nodes - they may be correct or incorrect
        for (int i = firstLeafIndex; i < size; i++) {
            correctTree[i] = tree[i];
        }

        // Build the correct tree from bottom to top, starting from the second last level (without leaves)
        //in binary tree, if index of parent = i, => index of child = 2*i+1 (for left) & 2*i+2 (for right)

         for (int i = firstLeafIndex - 1; i >= 0; i--) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            correctTree[i] = correctTree[leftChildIndex] + correctTree[rightChildIndex];
        }


        // Now we have a presumably correct tree
        // But one of the nodes in the leaf level might be incorrect
        // According to the condition, if the error is in a leaf, it's always the right leaf


        // Check for discrepancies between the correct and original tree
        for (int i = 0; i < size; i++) {
            if (tree[i] != correctTree[i]) {
               cntErrors++; // Found a discrepancy
                // If it's a leaf, we need to determine whether it's the right or left child
                if (i >= firstLeafIndex) {
                    //if the error is in a leaf, it's always the right leaf
                    // Check if this leaf is a right child
                    int parentIndex = (i - 1) / 2; //formula for checking parent index
                    int leftSiblingIndex = (i % 2 == 0) ? i - 1 : i;  // Formula finds left child. If i is even, then it is the right child.
                    int rightSiblingIndex = (i % 2 == 0) ? i : i + 1; // Formula finds right child. If i is odd, then it is the left child.

                    // If the root of the tree is invalid, parentIndex < 0 is triggered.
                    // If the parent is correct but one of the children is invalid, tree[parentIndex] == tree[leftSiblingIndex] + tree[rightSiblingIndex] is triggered.
                    // If the node is right (i % 2 == 0), then we return it immediately, even if other conditions are false.
                    if (i % 2 == 0 || parentIndex < 0 ||  tree[parentIndex] == tree[leftSiblingIndex] + tree[rightSiblingIndex]) {
                        return new int[] {i, correctTree[i]};
                    }
                    // Otherwise, the error might be in the parent node
                    else {
                        continue;
                    }
                } else {
                    // It's an internal node, just return it
                        return new int[] {i, correctTree[i]};
                    }

                }
            }

        // Check all parents (nodes up to the first leaf).
        for (int i = 0; i < firstLeafIndex; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            //Check if the left and right children exist.
            if (leftChildIndex < size && rightChildIndex < size) {
                if (tree[i] != tree[leftChildIndex] + tree[rightChildIndex]) {
                    //Checks if the parent value matches the sum of its children.
                    // If not, then: check if the right child is in the leaf zone
                    if (rightChildIndex >= firstLeafIndex) {
                        //correct value = parent − left child
                        return new int[] {rightChildIndex, tree[i] - tree[leftChildIndex]};
                    } else {
                        //If the right child is not a leaf, then: an error in the parent itself (tree[i]).
                        //Return the index of the parent (i) & the correct value for it: sum of its two children.
                        return new int[] {i, tree[leftChildIndex] + tree[rightChildIndex]};
                    }
                }
            }
        }

        //The last block always finds errors in the right leaves, even if correctTree did not detect them.
                for (int i = firstLeafIndex; i < size; i += 2) {
            if (i + 1 < size) {
                int parentIndex = (i - 1) / 2;
                if (tree[parentIndex] != tree[i] + tree[i + 1]) {
                    return new int[] {i + 1, tree[parentIndex] - tree[i]};
                }
            }
        }

        return new int[] {-1, -1}; // if we did nod found the error
    }
}

 */