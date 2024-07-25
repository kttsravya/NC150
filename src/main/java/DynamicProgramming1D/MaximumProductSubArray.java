package DynamicProgramming1D;

//https://leetcode.com/problems/maximum-product-subarray/editorial/
// this is an optimization of kadanes algorithm
// Kadanes algorithm asks this question at each index i from 0 to n: what is the maxSoFar at ith index
// ex" what is the maxSoFar at 0th index?, maxSoFar at 1th index? and so on..
// best explination on kaden's algorithm - https://www.youtube.com/watch?v=86CQq3pKSUw
public class MaximumProductSubArray {
    public static void main(String[] args){
        MaximumProductSubArray maxProductSubArray = new MaximumProductSubArray();
        int maxProduct = maxProductSubArray.maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0});
        System.out.println(maxProduct);
    }


    public int maxProduct(int[] nums) {
        int maxSoFarAtIthIndex = nums[0];
        int minSoFarAtIthIndex = nums[0];
        int max = maxSoFarAtIthIndex;

        for(int i = 1; i < nums.length; i ++){
            int current = nums[i];
            int tempMaxSoFar = Math.max(current*minSoFarAtIthIndex, Math.max(current, current*maxSoFarAtIthIndex));
            minSoFarAtIthIndex = Math.min(current*minSoFarAtIthIndex, Math.min(current, current*maxSoFarAtIthIndex));
            maxSoFarAtIthIndex = tempMaxSoFar;
            max = Math.max(max, maxSoFarAtIthIndex);
            System.out.println(" minSoFarAtIthIndex and maxSoFarAtIthIndex "+ minSoFarAtIthIndex +" "+ maxSoFarAtIthIndex);
            System.out.println("max " + max);
        }
        return max;
    }
}
