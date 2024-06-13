package Greedy;

public class MaximumSubArray {
    public static void main(String[] args){
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int[] nums = {2,-3,4,-2,2,1,-1,4};
        int maxSubArray = maximumSubArray.maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int runningSum = 0;
        for(int i = 0; i < nums.length; i ++){
            runningSum = runningSum + nums[i];
            max = Math.max(max, runningSum);
            if(runningSum < 0){
                runningSum = 0;
            }
        }
        return max;
    }
}
