package LeetCode.AirBnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int index = 0;
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, index, target, currentPath, result);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int index, int target, List<Integer> currentPath, List<List<Integer>> result) {
        // if currentSum == target
        if(target == 0){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        if(target < 0 || index == candidates.length){
            return;
        }

        currentPath.add(candidates[index]);
        combinationSumHelper(candidates, index, target - candidates[index], currentPath, result);
        currentPath.remove(currentPath.size() - 1);

        combinationSumHelper(candidates, index+1, target, currentPath, result);

    }
}
