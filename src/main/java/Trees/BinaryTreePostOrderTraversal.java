package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        node.right = right;
        right.left = left;

        BinaryTreePostOrderTraversal postOrderTraversal = new BinaryTreePostOrderTraversal();
        List<Integer> resultSet = postOrderTraversal.postorderTraversal(node);
        System.out.println(resultSet.toString());

        resultSet = postOrderTraversal.postorderTraversalRecursive(node);
        System.out.println(resultSet.toString());
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> isVisit = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        if(root != null){
            stack.add(root);
            isVisit.add(false);
        }
        while(!stack.isEmpty()){
          TreeNode popped = stack.pop();
          boolean isVisited = isVisit.pop();
          if(isVisited){
              list.add(popped.val);
          }else{
              stack.add(popped);
              isVisit.add(true);
              if(popped.right != null){
                  stack.add(popped.right);
                  isVisit.add(false);
              }
              if(popped.left != null){
                  stack.add(popped.left);
                  isVisit.add(false);
              }
          }
        }
        return list;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        postOrderTraversalRecursiveHelper(root, list);
        return list;
    }

    private void postOrderTraversalRecursiveHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrderTraversalRecursiveHelper(root.left, list);
        postOrderTraversalRecursiveHelper(root.right, list);
        list.add(root.val);
    }

}
