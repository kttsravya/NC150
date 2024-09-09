package SlidingWindow.educativePattern;

public class MinimumSubArraySum {
    public static void main(String[] args){

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minSubArrayLength = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right ++){
            currentSum = currentSum + nums[right];
            if(currentSum < target){
                continue;
            }
            while (currentSum >= target){
                minSubArrayLength = Math.min(minSubArrayLength, right - left + 1);
                currentSum = currentSum - nums[left];
                left ++;
            }
        }

        return minSubArrayLength == Integer.MAX_VALUE? 0 : minSubArrayLength;
    }
}
