public class findIncorrectNode {
    public static void main(String[] args) {
        int[] tree1 = {29, 13, 16, 5, 8, 9, 1};
        int[] result1 = Solution.findNumber(tree1);
        System.out.println("The incorrect number is on index " + result1[0] +
                " and must be chanced on " + result1[1]);

        int[] tree2 = {19, 9, 12, 4, 5, 4, 6, 2, 2, 1, 4, 1, 3, 2, 4};
        int[] result2 = Solution.findNumber(tree2);
        System.out.println("The incorrect number is on index " + result2[0] +
                " and must be chanced on " + result2[1]);
        }
    }