package Trees;

import org.junit.Assert;

import java.util.Stack;

public class InvertTree {

    public TreeNode invertBinaryTree(TreeNode root){
        invertBinaryTreeHelper(root);
        return root;
    }

    private void invertBinaryTreeHelper(TreeNode root) {
        if(root == null){
            return;
        }
        // Swapping left and right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTreeHelper(root.left);
        invertBinaryTreeHelper(root.right);
    }

    public TreeNode invertTreeViaPostOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> isVisit = new Stack<>();
        if (root != null) {
            stack.add(root);
            isVisit.add(false);
        }

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            boolean isVisited = isVisit.pop();
            if (!isVisited) {
                // Swapping left and right child
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;

                stack.add(current);
                isVisit.add(true);
                if (current.right != null) {
                    stack.add(current.right);
                    isVisit.add(false);
                }
                if (current.left != null) {
                    stack.add(current.left);
                    isVisit.add(false);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InvertTree invert = new InvertTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode invertedTree = invert.invertBinaryTree(root);
        Assert.assertEquals(invertedTree.left.val, 3);
        Assert.assertEquals(invertedTree.right.val, 2);
        TreeNode revertBack = invert.invertBinaryTree(root);
        Assert.assertEquals(revertBack.left.val, 2);
        Assert.assertEquals(revertBack.right.val, 3);
    }
}
