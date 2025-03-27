public class BinaryTree {
    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;
        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root != null) {

            displayHelper(root.left);
            System.out.print(root.data + " ");
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data < root.data) {
            return searchHelper(root.left, data);

        } else {
            return searchHelper(root.right, data);
        }
    }


    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println("Not found");
        }
    }

    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else {
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }

        }
        return root;

    }

    private int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }


    public void findMaxAndMin() {
        System.out.println(" Max number: " + findMaxHelper(root));
        System.out.println("Min number: " + findMinHelper(root));
    }

        /*
        if tree is not sorted

        public int findMaxHelper(Node root) {
            int numMax = root.data;
            if(root.left != null) {
                numMax = Math.max(numMax, findMaxHelper(root.left));
            }
            if(root.right != null) {
                numMax = Math.max(numMax, findMaxHelper(root.right));
            }
            return numMax;
        }
           */

    // if tree is sorted
    public int findMaxHelper(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public int findMinHelper(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }


}



