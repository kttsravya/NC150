package Trees;

public class BinaryTreeDiameter {
    //int diameter = 0;
    public static void main(String[] args){
        BinaryTreeDiameter bd = new BinaryTreeDiameter();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        int diameter = bd.diameterOfBinaryTree(root);
        System.out.println(diameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = {0};
        diameterOfBinaryTreeHelper(root, diameter);
        return diameter[0];
    }

    public int diameterOfBinaryTreeHelper(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int maxLengthOfLeftSubTree = diameterOfBinaryTreeHelper(root.left, diameter);
        int maxLengthOfRightSubTree = diameterOfBinaryTreeHelper(root.right, diameter);
        diameter[0] = Math.max(diameter[0], maxLengthOfLeftSubTree + maxLengthOfRightSubTree);
        System.out.println("diameter for root + " + root.val + "is " + diameter[0]);
        return 1 + Math.max(maxLengthOfLeftSubTree, maxLengthOfRightSubTree);
    }
}
