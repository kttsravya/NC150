package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args){
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = levelOrderTraversal.levelOrder(root);
        System.out.println(result.toString());
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size > 0){
                TreeNode parent = queue.poll();
                if(parent != null){
                    level.add(parent.val);
                }
                if(parent.left != null){
                    queue.add(parent.left);
                }
                if(parent.right != null){
                    queue.add(parent.right);
                }
                size --;
            }
            result.add(level);
        }
        return result;
    }
}
