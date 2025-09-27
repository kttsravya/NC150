package LeetCode.WalmartLabs_3Months_EMH;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency  {

    public int maxFrequencyElements(int[] nums) {
        int totalElementsWithMaxFrequency = 0;
        Map<Integer, Integer> elementWithFrequencies = new HashMap<>();
        int maxFrequency = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(elementWithFrequencies.get(nums[i]) != null){
                int currentFreq = elementWithFrequencies.get(nums[i]) + 1;
                maxFrequency = Math.max(maxFrequency, currentFreq);
                elementWithFrequencies.put(nums[i], currentFreq);
            }else{
                elementWithFrequencies.put(nums[i], 1);
                maxFrequency = Math.max(maxFrequency, 1);
            }
        }

        for(int i = 0; i < nums.length; i ++){
            if(elementWithFrequencies.get(nums[i]) == maxFrequency){
                totalElementsWithMaxFrequency ++;
            }
        }
        return totalElementsWithMaxFrequency;
    }
}
