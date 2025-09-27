package LeetCode.Paypal;

import java.util.Arrays;
//https://www.youtube.com/watch?v=sb2FNlfxQpg

public class MaxSumRangeQuery {
    int MOD = (int) Math.pow(10, 9.0) + 7;
    public static void main(String[] args){
        MaxSumRangeQuery maxSumRangeQuery = new MaxSumRangeQuery();
        int sum = maxSumRangeQuery.maxSumRangeQuery(new int[]{1,2,3,4,5}, new int[][]{{1,3},{0,1}});
        System.out.println(sum);
    }

    public int maxSumRangeQuery(int[] nums, int[][] requests){
        long sum = 0;
        int[] prefixSum = new int[nums.length];
        for(int[] request : requests){
            int start = request[0];
            int end = request[1] + 1;
            prefixSum[start] = prefixSum[start] + 1;
            if(end < nums.length){
                prefixSum[end] = prefixSum[end]+ -1;
            }
        }

        for(int i = 1; i < nums.length; i ++){
            prefixSum[i] = prefixSum[i] + prefixSum[i-1];
        }
        Arrays.sort(prefixSum);
        Arrays.sort(nums);

        for(int i = 0; i < nums.length ; i ++){
            long value = (long)nums[i]* (long)prefixSum[i];
            sum = sum + value;
        }

        return (int) (sum % MOD);
    }

}
