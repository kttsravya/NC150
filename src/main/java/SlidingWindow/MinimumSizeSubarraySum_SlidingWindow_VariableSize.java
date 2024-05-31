package SlidingWindow;

import org.junit.Assert;

public class MinimumSizeSubarraySum_SlidingWindow_VariableSize {

    public int minSubArrayLen(int target, int[] nums) {
        int minimumLengthSubArray = Integer.MAX_VALUE;
        int runningCount = 0;
        int startPointer = 0;
        for(int i = 0; i < nums.length; i ++){
            runningCount = runningCount + nums[i];
            if(runningCount >= target){
                int excess = runningCount - target;
                while(nums[startPointer] <= excess){
                    runningCount = runningCount - nums[startPointer];
                    excess = excess - nums[startPointer];
                    startPointer = startPointer + 1;
                }
                minimumLengthSubArray = Math.min(minimumLengthSubArray, ((i - startPointer) + 1));
            }
        }
        if(runningCount >= target){
            return minimumLengthSubArray;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        MinimumSizeSubarraySum_SlidingWindow_VariableSize minimumSizeSubarraySumSlidingWindowVariableSize = new MinimumSizeSubarraySum_SlidingWindow_VariableSize();
        int minimumLength = minimumSizeSubarraySumSlidingWindowVariableSize.minSubArrayLen(target, nums);
        Assert.assertEquals(2,minimumLength);
    }
}
