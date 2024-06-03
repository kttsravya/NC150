package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthOfBinaryTree {
    public static void main(String[] args){
        DepthOfBinaryTree depth = new DepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        int maxDepthOfTheTree =  depth.maxDepthIterative_BFS(root);
        System.out.println(maxDepthOfTheTree);
    }

    public int maxDepth(TreeNode root) {
        int count = 0;
        int maxDepth =  maxDepthHelper(root, count);
        //System.out.println(maxDepth);
        return maxDepth;
    }

    private int maxDepthHelper(TreeNode root, int count) {
        if(root == null){
            return count;
        }
        int left = maxDepthHelper(root.left, count + 1);
        int right = maxDepthHelper(root.right, count + 1);
        return Math.max(left, right);
    }

    public int maxDepthRecursiveWithoutMaintainingCounter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepthRecursiveWithoutMaintainingCounter(root.left);
        int right = maxDepthRecursiveWithoutMaintainingCounter(root.right);
        return 1 + Math.max(left, right);
    }

    public int maxDepthIterative_DFS(TreeNode root){
        int counter = 0;
        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        while(root != null){
            counter = counter + 1;
            stack.add(root);
            count.add(counter);
            root = root.left;
        }

        while(! stack.isEmpty()){
            TreeNode current = stack.pop();
            counter = count.pop();
            max = Math.max(max, counter);
            if(current.right != null){
                current = current.right;
                while(current != null){
                    counter = counter + 1;
                    stack.add(current);
                    count.add(counter);
                    current = current.left;
                }
            }
        }
        return max;
    }

    public int maxDepthIterative_BFS(TreeNode root){
     int numberOfLevels = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            numberOfLevels ++;
            System.out.println(numberOfLevels);
            int numberOfNodesInLevel = queue.size();
            for(int i = 0; i < numberOfNodesInLevel; i ++){
                TreeNode current = queue.remove();
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }
        return numberOfLevels;
    }
}

