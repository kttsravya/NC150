package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (root != null) {
            treeNodeStack.add(root);
            System.out.println(root.val);
            list.add(root.val);
            root = root.left;
        }
        while (!treeNodeStack.isEmpty()) {
            TreeNode current = treeNodeStack.pop();
            if (current.right != null) {
                current = current.right;
                while (current != null) {
                    list.add(current.val);
                    System.out.println(current.val);
                    treeNodeStack.add(current);
                    current = current.left;
                }
            }
        }
        return list;
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorderTraversalHelper(root, list);
        return list;
    }

    private void preorderTraversalHelper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        list.add(root.val);
        preorderTraversalHelper(root.left, list);
        preorderTraversalHelper(root.right, list);
    }

    public static void main(String[] args) {
        BinaryTreePreOrderTraversal preOrderTraversal = new BinaryTreePreOrderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;
        List<Integer> preOrderTraversalList = preOrderTraversal.preorderTraversalIterative(root);
        System.out.println(preOrderTraversalList.toString());
    }
}
