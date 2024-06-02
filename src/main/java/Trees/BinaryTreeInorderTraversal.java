package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    List<Integer> inOrderedElementList = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        traverseLeftSubTree(root);
        while( ! stack.isEmpty()){
            TreeNode current = stack.pop();
            inOrderedElementList.add(current.val);
            if(current.right != null){
                current = current.right;
                traverseLeftSubTree(current);
            }
        }
        return inOrderedElementList;
    }
    private void traverseLeftSubTree(TreeNode root){
        while (root != null){
            stack.add(root);
            root = root.left;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }

    private void inorderTraversalHelper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, list);
        System.out.println(root.val);
        list.add(root.val);
        inorderTraversalHelper(root.right, list);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal inorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;
        List<Integer> inOrderTraversalList = inorderTraversal.inorderTraversal(root);
        System.out.println(inOrderTraversalList.toString());
    }
}
