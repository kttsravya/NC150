package Trees;

class BalancedBinaryTreeHelper {
    private boolean isBalanced;
    private int maxHeightOfTheSubTree;

    public BalancedBinaryTreeHelper(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.maxHeightOfTheSubTree = height;
    }

    public boolean getIsBalanced() {
        return this.isBalanced;
    }

    public int getMaxHeightOfTheSubTree() {
        return this.maxHeightOfTheSubTree;
    }
}

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        boolean isBalanced = bbt.isBalanced(root);
        System.out.println(isBalanced);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        BalancedBinaryTreeHelper isBalanced = isBalancedHelper(root);
        return isBalanced.getIsBalanced();
    }

    private BalancedBinaryTreeHelper isBalancedHelper(TreeNode root) {
        if (root == null) {
            return new BalancedBinaryTreeHelper(true, 0);
        }
        BalancedBinaryTreeHelper leftSubTree = isBalancedHelper(root.left);
        BalancedBinaryTreeHelper rightSubTree = isBalancedHelper(root.right);
        boolean isBalanced = (leftSubTree.getIsBalanced()
                && rightSubTree.getIsBalanced()
                && Math.abs(leftSubTree.getMaxHeightOfTheSubTree() - rightSubTree.getMaxHeightOfTheSubTree()) <= 1);
        return new BalancedBinaryTreeHelper(isBalanced, 1 + Math.max(leftSubTree.getMaxHeightOfTheSubTree(), rightSubTree.getMaxHeightOfTheSubTree()));
    }
}
