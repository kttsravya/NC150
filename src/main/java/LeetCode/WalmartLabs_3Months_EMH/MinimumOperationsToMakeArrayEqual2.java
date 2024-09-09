package LeetCode.WalmartLabs_3Months_EMH;

public class MinimumOperationsToMakeArrayEqual2 {
    public static void main(String[] args){
        MinimumOperationsToMakeArrayEqual2 minimumOperationsToMakeArrayEqual2 = new MinimumOperationsToMakeArrayEqual2();
        long num = minimumOperationsToMakeArrayEqual2.minOperations(new int[]{4,3,1,4}, new int[]{1,3,7,1}, 3);
        System.out.println(num);
    }

    public long minOperations(int[] nums1, int[] nums2, int k) {
        long numOfIncrements = 0;
        long numOfDecrements = 0;
        if(k == 0){
            for(int i = 0; i < nums1.length; i ++){
                if(nums1[i] != nums2[i]){
                    return -1;
                }
            }
            return 0;
        }
        for(int i = 0; i < nums1.length; i ++){
            if(Math.abs(nums1[i] - nums2[i])% k != 0){
                return -1;
            }
            if (nums1[i] > nums2[i]){
                long temp = nums1[i] - nums2[i];
                long numOfDecrs = temp/k;
                numOfDecrements  = numOfDecrements + numOfDecrs;
            }
            if (nums1[i] < nums2[i]){
                long temp = nums2[i] - nums1[i];
                long numOfIncrs = temp/k;
                numOfIncrements = numOfIncrements + numOfIncrs;
            }
        }
        return numOfIncrements == numOfDecrements ?  numOfIncrements : -1;
    }
}
