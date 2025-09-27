package DynamicProgramming2D;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        int numWays = targetSum.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
        System.out.println(numWays);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();
        int[][] cache = new int[nums.length][2*totalSum+1];
        for(int i = 0; i < nums.length; i ++){
            Arrays.fill(cache[i], -1);
        }
        return findTargetSumWaysHelper(nums, target, 0, 0, cache, totalSum);
    }

    private int findTargetSumWaysHelper(int[] nums, int target, int currentSum, int index, int[][] cache, int totalSum) {
        if (index == nums.length) {
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        if (cache[index][totalSum + currentSum] != -1) {
            return cache[index][totalSum + currentSum];
        }
        int numOfWays = findTargetSumWaysHelper(nums, target, currentSum + nums[index], index + 1, cache, totalSum)
                + findTargetSumWaysHelper(nums, target, currentSum - nums[index], index + 1, cache, totalSum);
        return cache[index][totalSum + currentSum] = numOfWays;
    }
}
