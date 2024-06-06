package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args){
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2, 5, 6, 9}, 9);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int index = 0;
        combinationSumHelper(nums, combination, index, target, result);
        System.out.println(result.toString());
        return result;
    }

    private void combinationSumHelper(int[] nums, List<Integer> combination, int index, int target, List<List<Integer>> result) {

        if(target == 0){
            System.out.println(combination.toString());
            result.add(List.copyOf(combination));
            return;
        }
        if(target < 0 || index >= nums.length){
            return;
        }

        combination.add(nums[index]);
        combinationSumHelper(nums, combination, index, target - nums[index], result);

        combination.remove(combination.size() - 1);
        combinationSumHelper(nums,combination, index + 1, target, result);

    }
}
