package DynamicProgramming1D;

public class PartitionEqualSubSetSum {
    public static void main(String[] args){
        PartitionEqualSubSetSum parition = new PartitionEqualSubSetSum();
        boolean canPartition = parition.canPartition(new int[]{1,5,11,5});
        System.out.println(canPartition);
    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum = sum+num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum/2;
        Boolean[][] memo = new Boolean[nums.length][target+1];
        return canPartitionHelper(nums, 0, target, memo);
    }



    public boolean canPartitionHelper(int[] nums, int index, int target, Boolean[][] memo){
        if(index == nums.length || target < 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        if (memo[index][target]!= null){
            return memo[index][target];
        }
        boolean result = canPartitionHelper(nums, index+1, target-nums[index], memo) ||
                canPartitionHelper(nums, index+1, target, memo);
        return memo[index][target] = result;
    }



    public boolean canPartition_BottomUp(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum = sum+num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum/2;
        Boolean[][] memo = new Boolean[nums.length+1][target+1];
        for(int i = 0; i <= nums.length; i ++){
            memo[i][0] = true;
        }
        for(int i = 0; i <= target; i ++){
            memo[nums.length][i] = false;
        }
        for(int i = nums.length - 1; i >= 0; i --){
            for(int j = 1; j <= target; j ++){
                if(j >= nums[i]){
                    memo[i][j] = memo[i+1][j-nums[i]];
                }
               if(memo[i][j] == null){
                   memo[i][j] = memo[i+1][j];
               }else{
                   memo[i][j] = memo[i][j] || memo[i+1][j];
               }
            }
        }
        return memo[0][target];
    }

}
