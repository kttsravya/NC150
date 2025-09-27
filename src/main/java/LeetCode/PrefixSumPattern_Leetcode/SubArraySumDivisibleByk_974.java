package LeetCode.PrefixSumPattern_Leetcode;

import java.util.HashMap;
import java.util.Map;
//neetcode pyton - https://www.youtube.com/watch?v=bcXy-T4Sc3E
public class SubArraySumDivisibleByk_974 {

    public static void main(String[] args){
        SubArraySumDivisibleByk_974 subArraySumDivisibleByk_974 = new SubArraySumDivisibleByk_974();
        int res = subArraySumDivisibleByk_974.subarraysDivByK(new int[]{-1,2,9}, 2);
        System.out.println("res is " + res);
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> modulusFrequencyMap = new HashMap<>();
        int prefixSum = 0;
        int res = 0;

        for(int i = 0; i < nums.length; i ++){
            prefixSum = prefixSum + nums[i];
            if(prefixSum % k == 0){
                System.out.println("inside equal to 0");
                res = res + 1;
            }
            // to handle negative key's. (python by default handles with prefixsum % k)
            // but java need to handle it.
            int modulusKey = ((prefixSum % k)+k)%k;
            System.out.println("moduluskey is " + modulusKey);
            if(modulusFrequencyMap.containsKey(modulusKey)){
                res = res + modulusFrequencyMap.get(modulusKey);
                modulusFrequencyMap.put(modulusKey, modulusFrequencyMap.get(modulusKey)+1);
            }else{
                modulusFrequencyMap.put(modulusKey, 1);
            }
        }
        return res;
    }
}
