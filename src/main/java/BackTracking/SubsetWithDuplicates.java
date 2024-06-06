package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithDuplicates {
    public static void main(String[] args){
        SubsetWithDuplicates subsetWithDuplicates = new SubsetWithDuplicates();
        int[] nums = {1, 2,2,2};
        List<List<Integer>> result = subsetWithDuplicates.subsetWithDuplicates(nums);
        System.out.println(result);
    }
    public List<List<Integer>> subsetWithDuplicates(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        subsetWithDuplicatesHelper(nums, index, subset, result);
        return result;
    }

    private void subsetWithDuplicatesHelper(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        if(index == nums.length){
            result.add(List.copyOf(subset));
            return;
        }
        // decision to add current element to the subset
        subset.add(nums[index]);
        subsetWithDuplicatesHelper(nums, index+1, subset, result);

        // decision to not include current element to the subset
        subset.remove(subset.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]){
            index ++;
        }
        subsetWithDuplicatesHelper(nums, index + 1, subset, result);
    }
}
