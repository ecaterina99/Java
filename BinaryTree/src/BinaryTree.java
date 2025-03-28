
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeStructure tree = new BinaryTreeStructure();

        tree.createTree();
        System.out.println("Preorder: ");
        tree.preorderTraversal(tree.root);
        System.out.println(" ");
        System.out.println("Inorder: ");
        tree.inorderTraversal(tree.root);
        System.out.println(" ");
        System.out.println("Postorder: ");
        tree.postorderTraversal(tree.root);
        System.out.println(" ");

        System.out.println("Total levels: "+tree.countTreeHeight(tree.root));
        System.out.println("Total nodes: "+tree.countNodes(tree.root));

       int keyToDelete=2;
       tree.root=tree.deleteNode(tree.root,keyToDelete);
       System.out.println("after deletion: ");
       tree.preorderTraversal(tree.root);
    }
}