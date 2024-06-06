package BackTracking;

import java.util.ArrayList;
import java.util.List;

// Leet code solution reference
// https://leetcode.com/problems/subsets/solutions/5186392/so-easy-and-detailed-even-a-child-can-understand-this-my-words/
// https://neetcode.io/problems/subsets
// hint: if you have a choice to make then it is backtracking problem. it is a brute force approach, to explore all possibilities and return the results that matches the requirement.
public class Subsets {
    public static void main(String[] args){
        Subsets subsets = new Subsets();
        subsets.subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        subsetHelper(nums, index, output, result);
        System.out.println(result.toString());
        return result;

    }

    private void subsetHelper(int[] nums, int index, List<Integer> output, List<List<Integer>> result) {
        // outbound, went beyond leaf nodes level
        if(index == nums.length){
            System.out.println(output.toString());
            result.add(List.copyOf(output));
            return;
        }

        // include current element
        output.add(nums[index]);
        subsetHelper(nums, index + 1, output, result);

        // does not include current element, removes element from end of the list
        output.remove(output.size() - 1);
        subsetHelper(nums, index + 1, output, result);
    }
}
