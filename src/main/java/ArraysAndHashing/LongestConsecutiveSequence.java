package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args){
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int lc = lcs.longestConsecutive(new int[]{2,20,4,10,3,4,5});
        System.out.println(lc);
    }

    public int longestConsecutive(int[] nums) {
        int maxLengthOfConsecutiveSequence = 0;
        // step 1: iterate through the array and add elements to the set
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        // step 2: traverse through the array and check if current element is the start of the sequence,
        // if so, find the length of the consecutive sequence
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int count = 0;
            if (isCurrentStartOfSequence(current, hashSet)) {
                count = count + 1;
                current = current + 1;
                while (hashSet.contains(current)) {
                    count++;
                    current++;
                }
                maxLengthOfConsecutiveSequence = Math.max(count, maxLengthOfConsecutiveSequence);
            }
        }
        return maxLengthOfConsecutiveSequence;
    }

    private boolean isCurrentStartOfSequence(int current, Set<Integer> hashSet) {
        boolean isStartOfSequence = ! hashSet.contains(current - 1);
        return isStartOfSequence;
    }

}
