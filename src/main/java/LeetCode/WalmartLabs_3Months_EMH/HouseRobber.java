package LeetCode.WalmartLabs_3Months_EMH;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args){
       HouseRobber houseRobber = new HouseRobber();
       int rob = houseRobber.rob(new int[]{1,2,3,1});
       System.out.println(rob);
    }

    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return robHelper(nums, 0, cache);
    }

    private int robHelper(int[] nums, int index, int[] cache) {
        if(index >= nums.length){
            return 0;
        }
        if(cache[index] != -1){
            return cache[index];
        }
        int maxAmount = Math.max(robHelper(nums, index+2, cache) + nums[index]
        ,robHelper(nums, index+1, cache));
        return cache[index] = maxAmount;
    }


}


