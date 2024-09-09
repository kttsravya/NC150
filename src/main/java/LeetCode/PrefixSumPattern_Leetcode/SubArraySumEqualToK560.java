package LeetCode.PrefixSumPattern_Leetcode;

import java.util.HashMap;
import java.util.Map;

// TUF: https://www.youtube.com/watch?v=xvNwoz-ufXA
public class SubArraySumEqualToK560 {

    public static void main(String[] args) {
        SubArraySumEqualToK560 sumEqualToK560 = new SubArraySumEqualToK560();
        int subArray = sumEqualToK560.subarraySumRevision(new int[]{1,2,1,2,1}, 3);
        System.out.println(subArray);
    }

    public int subarraySumRevision(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            prefixSum = prefixSum + nums[i];
            System.out.println("prefix sum is "+prefixSum);
            if(prefixSum - k == 0){
                System.out.println("entered 0");
                count = count + 1;
            }
            if(map.containsKey(prefixSum - k)){
                count = count + map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) +1);
            System.out.println("map contains  "+ prefixSum + " " + map.get(prefixSum));
            System.out.println("count is " + count);
        }
        return count;
    }

    // Logic: if current prefix sum is SUM and we are looking for subarray of sum k. (x + k = SUM)
    // then x = SUM - k;
    // then we could find prefix subarray that has the sum of x. we can increment our total count by 1
    // if we could find prefix subarray multiple subarray that has sum of x. we can increment our total count that many times.
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            int previousPrefixkey = prefixSum - k;
            if (map.containsKey(previousPrefixkey)) {
                int frequency = map.get(previousPrefixkey);
                count = count + frequency;
            }
            int prefixKey = map.getOrDefault(prefixSum, 0);
            map.put(prefixSum, prefixKey + 1);
            }
        return count;
    }


}
