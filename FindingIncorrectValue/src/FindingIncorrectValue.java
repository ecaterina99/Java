
public class FindingIncorrectValue {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.createTree();
        System.out.println("Postorder: ");
        tree.postorderTraversal(tree.root);
        System.out.println(" ");

        System.out.println("sum: "+tree.countSum(tree.root));

        System.out.println("sum of all leaves: "+tree.sumOfLeaves(tree.root));
        System.out.println("sum of left leaves: "+tree.sumOfLeftLeaves(tree.root));
        System.out.println("sum of right leaves: "+tree.sumOfRightLeaves(tree.root));

    tree.findIncorrectNumber(tree.root);

    }
}