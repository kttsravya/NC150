package LeetCode.Paypal;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args){
        HouseRobber houseRobber = new HouseRobber();
        int totalAmount = houseRobber.rob(new int[]{1,2,3,1});
        System.out.println(totalAmount);
    }

    public int rob(int[] nums){
        int index = 0;
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return robHelper(nums, index, cache);
    }

    private int robHelper(int[] nums, int index, int[] cache) {
        if(index >= nums.length){
           return 0;
        }
        if(cache[index] != -1){
            return cache[index];
        }
        int max = Integer.MIN_VALUE;
        max = Math.max(nums[index] + robHelper(nums, index+2, cache),
        robHelper(nums, index+1, cache));
        return cache[index] = max;
    }
}
