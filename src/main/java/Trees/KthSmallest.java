package Trees;

import java.util.Stack;

public class KthSmallest {
    public static void main(String[] args){
        KthSmallest kthSmallest = new KthSmallest();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int k = 1;
        int kthSMallest = kthSmallest.kthSmallest(root, k);
        System.out.println(kthSMallest);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null){
            stack.add(root);
            root = root.left;
        }
        while (!stack.isEmpty()){
            TreeNode current = stack.pop();
            k--;
            if(k == 0){
                return current.val;
            }
            if(current.right != null){
                current = current.right;
                while (current != null){
                    stack.add(current);
                    current = current.left;
                }
            }
        }
        return -1;
    }

}
