package DynamicProgramming1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Leet code solution using all approaches
//https://leetcode.com/problems/longest-increasing-subsequence/solutions/3367833/recursive-brute-force-recursion-with-caching-dynamic-programming-with-tabulation
public class LongestIncreasingSubSequence {
    public static void main(String[] args){
        LongestIncreasingSubSequence longestIncreasingSubSequence = new LongestIncreasingSubSequence();
        int longestLength = longestIncreasingSubSequence.lengthOfLISRecursiveWithCache(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(longestLength);
    }

    public int lengthOfLISRecursiveWithCache(int[] nums){
        List<Integer> subSequenceList = new ArrayList<>();
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        int result = 0;
        for(int i = 0; i < nums.length; i ++){
           result =  Math.max(result, lengthOfLISRecursiveWithCacheHelper(nums, subSequenceList, i, cache));
        }

        System.out.println("cache is " + Arrays.toString(cache));
        return result;
    }
    private int lengthOfLISRecursiveWithCacheHelper(int[] nums, List<Integer> subSequenceList, int index, int[] cache) {
        if(index >= nums.length){
            return 0;
        }
        if(cache[index] != -1){
            return cache[index];
        }
        int longestSubSequenceAtCurrentIndex = 0;
        int current = nums[index];
        for(int j = index + 1 ; j < nums.length; j ++){
            if(nums[j] > current){
                longestSubSequenceAtCurrentIndex = Math.max(longestSubSequenceAtCurrentIndex,
                        lengthOfLISRecursiveWithCacheHelper(nums, subSequenceList, j, cache));
            }
        }
        return cache[index] = 1 + longestSubSequenceAtCurrentIndex;
    }

    public int lengthOfLIS_BottomUp(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] = dp[i] + 1;
        }
        for(int i = 0; i < dp.length; i ++){
            if(dp[i] > maxLength){
                maxLength = dp[i];
            }
        }
        return maxLength;
    }


}
