package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> list = binaryTreeRightSideView.rightSideView(root);
        System.out.println(list.toString());
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode parent = queue.poll();
                if (parent != null) {
                    level.add(parent.val);
                }
                if (parent.left != null) {
                    queue.add(parent.left);
                }
                if (parent.right != null) {
                    queue.add(parent.right);
                }
                size--;
            }
            result.add(level.get(level.size() - 1));
        }
        return result;
    }

    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewRecursiveHelper(root, result, 0);
        return result;
    }

    private void rightSideViewRecursiveHelper(TreeNode root, List<Integer> result, int currentLevel) {
        if(root == null){
            return;
        }
        if(result.size() <= currentLevel){
            result.add(root.val);
        }
        rightSideViewRecursiveHelper(root.right, result, currentLevel + 1);
        rightSideViewRecursiveHelper(root.left, result, currentLevel + 1);
    }
}
