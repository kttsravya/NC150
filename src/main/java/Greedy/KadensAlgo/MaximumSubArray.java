package Greedy.KadensAlgo;

public class MaximumSubArray {
    public static void main(String[] args){
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int[] nums = {2,-3,4,-2,2,1,-1,4};
        int maxSubArray = maximumSubArray.maxSubArray_Revision(nums);
        System.out.println(maxSubArray);
    }

   /* public int maxSubArray(int[] nums) {
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
    }*/
    // Kadens algorithm asks the question what is the maximum sum so far at this point?
    // It asks what is the maxium sum at index 0? what is the maximum sum at index 1? maximum sum at index 2?, etc..
     public int maxSubArray_Revision(int[] nums) {
         int maxSoFar = Integer.MIN_VALUE;
         int runningSum = 0;
         for(int i = 0; i < nums.length; i ++){
             if(runningSum < 0){
                 runningSum = 0;
             }
             runningSum = runningSum + nums[i];
             maxSoFar = Math.max(maxSoFar, runningSum);
         }
         return maxSoFar;
    }
}
