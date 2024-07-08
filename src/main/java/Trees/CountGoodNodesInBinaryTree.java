package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountGoodNodesInBinaryTree {
    int counter = 0;
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        //root.right.right = new TreeNode(5);
        CountGoodNodesInBinaryTree count = new CountGoodNodesInBinaryTree();
        int goodNodesCounter = count.goodNodesOptimized(root);
        System.out.println(goodNodesCounter);
    }

    public int goodNodes(TreeNode root) {
        int level = 1;
        ArrayList<Integer> maxList = new ArrayList<>();
        maxList.add(Integer.MIN_VALUE); // dummy value
        goodNoesHelper(root, level, maxList);
        return counter;
    }



    private void goodNoesHelper(TreeNode current, int level, ArrayList<Integer> maxList) {
        if(current == null){
            return;
        }
        if(current.val >= maxList.get(level - 1)){
            counter ++;
            maxList.add(level, current.val);
        }else{
            maxList.add(level, maxList.get(level - 1));
        }
        goodNoesHelper(current.left, level + 1, maxList);
        // creating a sublist from root to currentLevel
        List<Integer> subList = maxList.subList(0, level+1);
        ArrayList<Integer> newMaxList = new ArrayList<>(subList);
        goodNoesHelper(current.right, level + 1, newMaxList);
    }

    public int goodNodesOptimized(TreeNode root) {
        int max = root.val;
        int counterLocal = goodNoesHelperOptimized(root, max);
        return counterLocal;
    }

    private int goodNoesHelperOptimized(TreeNode current, int max) {
        if(current == null){
            return 0;
        }
        int result = 0;
        if(current.val >= max){
            result = result + 1;
            max = current.val;
        }
        result = result + goodNoesHelperOptimized(current.left,  max);
        result = result + goodNoesHelperOptimized(current.right, max);
        return result;
    }
}
