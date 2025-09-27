package LeetCode.PrefixSumPattern_Leetcode;

import java.util.HashMap;
import java.util.Map;
// neetcode video
public class continousSubArraySum523 {
    public static void main(String[] args){

    }

    public boolean checkSubArraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        prefix[0] = nums[0];
        for(int i = 1; i < prefix.length; i ++){
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for(int currentIndex = 0; currentIndex < prefix.length; currentIndex ++){
            int key = prefix[currentIndex] % k;
            if(hashMap.containsKey(key)){
               if((currentIndex - hashMap.get(key)) > 1){
                   return true;
                }
            }else{
                hashMap.put(key, currentIndex);
            }
        }
        return false;
    }


}
