package LeetCode.PrefixSumPattern_Leetcode;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum111_437 {
    int pathCount = 0;
    public static void main(String[] args){

    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> previousPrefixSum = new HashMap<>();
        long prefixSum = 0;
        pathSumHelper(root, prefixSum, previousPrefixSum, targetSum);
        return pathCount;
    }

    private void pathSumHelper(TreeNode root, long prefixSum, Map<Long, Integer> previousPrefixSum, int targetSum) {
        if(root == null){
            return;
        }
        prefixSum = prefixSum + root.val;
        if(prefixSum == targetSum){
            pathCount = pathCount + 1;
        }
        if(previousPrefixSum.containsKey(prefixSum - targetSum)){
                pathCount = pathCount + previousPrefixSum.get(prefixSum - targetSum);
        }
        previousPrefixSum.put(prefixSum, previousPrefixSum.getOrDefault(prefixSum, 0) + 1);
        pathSumHelper(root.left, prefixSum, previousPrefixSum, targetSum);
        pathSumHelper(root.right, prefixSum, previousPrefixSum, targetSum);
        previousPrefixSum.put(prefixSum, previousPrefixSum.get(prefixSum) - 1);
    }


}


