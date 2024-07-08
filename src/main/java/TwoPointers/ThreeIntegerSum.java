package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeIntegerSum {
    public static void main(String[] args) {
        ThreeIntegerSum threeSum = new ThreeIntegerSum();
        //List<List<Integer>> res = threeSum.threeSumBacktracking(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> res = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int twoPairSumTarget = -1 * nums[i];
            int lowPointer = i + 1;
            int highPointer = nums.length - 1;
            while (lowPointer < highPointer) {
                if(lowPointer - 1 > i && nums[lowPointer] == nums[lowPointer - 1]){
                    lowPointer ++;
                    continue;
                }
                if(highPointer + 1 < nums.length && nums[highPointer] == nums[highPointer + 1]){
                    highPointer --;
                    continue;
                }
                int currentTwoSum = nums[lowPointer] + nums[highPointer];
                if (currentTwoSum == twoPairSumTarget) {
                    List<Integer> list = Arrays.asList(nums[i], nums[lowPointer], nums[highPointer]);
                    result.add(list);
                    lowPointer++;
                    highPointer--;
                } else if (currentTwoSum < twoPairSumTarget) {
                    lowPointer++;
                } else {
                    highPointer--;
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSumFor(int[] nums){
        Arrays.sort(nums);
        System.out.println("Sorted array is "+ Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i ++){
            if(i - 1 >= 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 1; j ++){
                if(j - 1 > i && nums[j] == nums[j - 1]){
                    continue;
                }
                for(int k = j + 1; k < nums.length; k ++){
                    if(k - 1 > j && nums[k] == nums[k - 1]){
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumWhile(int[] nums){
        Arrays.sort(nums);
        System.out.println("Sorted array is "+ Arrays.toString(nums));
        int i = 0;
        int j = 1;
        int k = 2;
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(i < nums.length){
            j = i + 1;
            while(j < nums.length){
                k = j + 1;
                while(k < nums.length){
                    //System.out.println("i j and k is "+ i + " "+j+" "+k);
                    int sum = nums[i]+ nums[j]+ nums[k];
                    if(sum == target){
                        System.out.println("target matched");
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        //System.out.println("list added"+list.toString());
                        result.add(list);
                    }
                    while(k+1 < nums.length && nums[k] == nums[k + 1]){
                        k ++;
                    }
                    k++;
                }
                //System.out.println("broke out of k loop");
                while(j+1 < nums.length && nums[j] == nums[j + 1]){
                    j ++;
                }
                j++;
            }
            while(i+1 < nums.length && nums[i] == nums[i + 1]){
                i ++;
            }
            i ++;
        }
        return result;
    }

    //O(n^2)
    public List<List<Integer>> threeSumBacktracking(int[] nums) {
        int index = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pathSum = new ArrayList<>();
        int sum = 0;
        Arrays.sort(nums);
        System.out.println("Input is " + Arrays.toString(nums));
        Integer prev = null;
        threeSumHelper(nums, pathSum, result, index, sum, prev);
        return result;
    }

    private void threeSumHelper(int[] nums, List<Integer> current, List<List<Integer>> result, int index, int sum, Integer prev) {
        if (current.size() == 3) {
            if (sum == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        while (prev != null && index < nums.length && nums[index] == prev.intValue()) {
            index++;
        }
        if (index >= nums.length) {
            return;
        }
        current.add(nums[index]);
        threeSumHelper(nums, current, result, index + 1, sum + nums[index], prev);
        int elementToBePopped = current.get(current.size() - 1);
        current.remove(current.size() - 1);
        threeSumHelper(nums, current, result, index + 1, sum, elementToBePopped);
    }
}
