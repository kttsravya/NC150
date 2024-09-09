package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/


public class Permuatations {
    public static void main(String[] args) {
        Permuatations permute = new Permuatations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute.permuteRev(nums);
        System.out.println(result.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permute = new ArrayList<>();
        int lengthOfInput = nums.length;
        // try to use LinkedList
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        permuteHelper(numList, lengthOfInput, permute, result);
        return result;
    }

    private void permuteHelper(List<Integer> nums, int lengthOfInput, List<Integer> permute, List<List<Integer>> result) {
        //System.out.println(nums.toString());
        if (nums.size() == 0) {
            System.out.println(permute.toString());
            result.add(new ArrayList<>(List.copyOf(permute)));
            return;
        }
        for (int i = 0; i < lengthOfInput; i++) {
            int firstElement = nums.remove(0);
            permute.add(firstElement);
            permuteHelper(nums, nums.size(), permute, result);
            permute.remove(permute.size() - 1);
            nums.add(firstElement);
        }
    }

    public List<List<Integer>> permuteRev(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        Integer[] inputList = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        List<Integer> list = new ArrayList<>(Arrays.asList(inputList));
        permuteRevHelper(list, nums.length, currentPermutation, result);
        return result;
    }

    private void permuteRevHelper(List<Integer> nums, int lengthOfInput,
                                  List<Integer> permute, List<List<Integer>> result) {
        if(nums.size() == 0){
            result.add(List.copyOf(permute));
            return;
        }

        for(int i = 0; i < lengthOfInput; i ++){
           int currentElement =  nums.remove(0);
           permute.add(currentElement);
           permuteRevHelper(nums, nums.size(), permute, result);
           permute.remove(permute.size() - 1);
           nums.add(currentElement);
        }

    }
}
