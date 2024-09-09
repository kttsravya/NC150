package LeetCode.PrefixSumPattern_Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualsK325 {

    public static void main(String[] args){
        MaximumSizeSubArraySumEqualsK325 maximumSizeSubArraySumEqualsK = new MaximumSizeSubArraySumEqualsK325();
        int max = maximumSizeSubArraySumEqualsK.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3);
        System.out.println(max);
    }

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMinIndex = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int prefixSumSoFar = 0;
        prefixSumMinIndex.put(0, 0);

        for(int i = 0; i < nums.length; i ++){
            prefixSumSoFar = prefixSumSoFar + nums[i];
            int prefixKey = prefixSumSoFar - k;
            if(prefixSumMinIndex.containsKey(prefixKey)){
                 max = Math.max(max, (i+1) - prefixSumMinIndex.get(prefixKey));
            }
            if(! prefixSumMinIndex.containsKey(prefixSumSoFar)){
                prefixSumMinIndex.put(prefixSumSoFar, i+1);
            }
        }
        return max == Integer.MIN_VALUE? 0:max;
    }
}
