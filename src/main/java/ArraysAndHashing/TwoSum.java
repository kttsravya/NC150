package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSumUsingHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(nums[0], 0);
        for(int i = 1; i < nums.length; i ++){
            if(indexMap.containsKey(target - nums[i])){
                return new int[]{indexMap.get(target - nums[i]), i};
            }else{
                indexMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumUsingHashMapApproach2(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(indexMap.containsKey(target - nums[i])){
                return new int[]{indexMap.get(target - nums[i]), i};
            }else{
                indexMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

   public int[] twoSumUsingTwoPointers(int[] nums, int target) {
     int startPointer = 0;
     int endPointer = nums.length - 1;
     Arrays.sort(nums);
     while(startPointer < endPointer){
         if(nums[startPointer] + nums[endPointer] == target){
             return new int[]{startPointer, endPointer};
         }else if (Math.abs(nums[startPointer] + nums[endPointer]) > target){
             endPointer = endPointer - 1;
         }else{
             startPointer = startPointer + 1;
         }
     }
     return new int[]{-1, -1};
    }

    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 4, 5, 6};
        int target = 7;
        int[] targetSum = twoSum.twoSumUsingHashMap(nums, target);
        System.out.println(Arrays.toString(targetSum));

        targetSum = twoSum.twoSumUsingTwoPointers(nums, target);
        System.out.println(Arrays.toString(targetSum));

    }
}
