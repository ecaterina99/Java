import java.awt.geom.QuadCurve2D;

public class BinaryTreeStructure {

    Node root;

    public BinaryTreeStructure() {
        root = null;
    }

    public void createTree(){
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    //preorder traversal (root--left--right)
    public void preorderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    //inorderTraversal (left--root-right)
    public void inorderTraversal(Node node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    //postorder traversal (left--right--root)
    public void postorderTraversal(Node node){
        if(node == null){
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

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

}


//for binary search tree
/*
 //delete node
    public Node deleteNode(Node root, int key){
       //if tree is empty
        if(root == null){
            return null;
        }
        //search node
        if( key<root.data){
            root.left = deleteNode(root.left, key);
        }
        else if( key>root.data){
            root.right = deleteNode(root.right, key);
        }
        //found node
        else{
            //node without leafs
            if(root.left == null && root.right == null){
                return null;
            }
            //if it has only 1 child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //if it has 2 children

            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);

        }
        return root;
    }

    private int minValue(Node root){
       int minV = root.data;
       while(root.left != null){
           minV = root.left.data;
           root = root.left;
       }
       return minV;
    }
 */