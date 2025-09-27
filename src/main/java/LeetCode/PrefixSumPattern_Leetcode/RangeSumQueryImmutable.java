package LeetCode.PrefixSumPattern_Leetcode;

public class RangeSumQueryImmutable {
    int[] prefix;
    public static void main(String[] args){

    }

    public RangeSumQueryImmutable(int[] nums) {
        this.prefix = new int[nums.length];
         for(int i = 0; i < nums.length; i ++){
             prefix[i] = nums[i];
         }
        for(int i = 1; i < nums.length; i ++){
            prefix[i] = prefix[i -1] + prefix[i];
        }

    }

    public int sumRange(int left, int right) {
        if(left > 0){
            return prefix[right] - prefix[left - 1];
        }
        return prefix[right];
    }
}
