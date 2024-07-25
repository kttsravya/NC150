package DynamicProgramming1D;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args){
        HouseRobber houseRobber = new HouseRobber();
        int rob = houseRobber.rob(new int[]{1,2,3,1});
        System.out.println(rob);
    }

    // dynamic programming: recursive top-to-bottom with cache
    // pros: cache to save results of recursive calls
    // cons: compiler need to maintain call-stack which could get very long and can
    //..lead to stack overflow errors(no pun intended!)
    public int robRecursive(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        int currentIndex = 0;
        return robHelper(nums, cache, currentIndex);
    }

    private int robHelper(int[] nums, int[] cache, int currentIndex) {
        if(currentIndex >= nums.length){
            return 0;
        }
        if(cache[currentIndex] != -1){
            return cache[currentIndex];
        }
        cache[currentIndex] = Math.max(
                nums[currentIndex] + robHelper(nums, cache, currentIndex + 2),
                robHelper(nums, cache, currentIndex + 1));
        return cache[currentIndex];
    }

    // dynamic programming : bottom up approach
    public int robBottomUp(int[] nums) {
        int[] maxProfit = new int[nums.length + 1];
        maxProfit[maxProfit.length - 1] = 0;
        maxProfit[maxProfit.length - 2] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i --){
            maxProfit[i] = Math.max(nums[i]+ maxProfit[i + 2], maxProfit[i+1]);
        }
        return maxProfit[0];
    }

    // dynamic programming : bottom up memory optimized approach
    public int rob(int[] nums) {
        int alternateHouse = 0;
        int adjacentHouse = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i --){
            int currentHouse = Math.max(nums[i]+ alternateHouse, adjacentHouse);
            alternateHouse = adjacentHouse;
            adjacentHouse = currentHouse;
        }
        return adjacentHouse;
    }
}
