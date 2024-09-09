package LeetCode.PrefixSumPattern_Leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArrayWithSum930 {
    public static void main(String[] args){

    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        int prefixSumSoFar = 0;
        //prefixSumFrequency.put(0,1);
        for(int i = 0; i < nums.length; i ++){
            prefixSumSoFar = prefixSumSoFar + nums[i];
            if(prefixSumSoFar == goal){
                count ++;
            }
            int previousPrefixSumKey = prefixSumSoFar - goal;
            if(prefixSumFrequency.containsKey(previousPrefixSumKey)){
                count = count + prefixSumFrequency.get(previousPrefixSumKey);
            }
            int frequency = prefixSumFrequency.getOrDefault(prefixSumSoFar, 0);
            prefixSumFrequency.put(prefixSumSoFar, frequency+1);
        }
        return count;
    }
}
