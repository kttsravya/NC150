package Greedy;


import java.util.HashMap;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        boolean canJump = jumpGame.canJumpGreedy(new int[]{1,2,1,0,1});
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {
       int goal = nums.length - 1;
       for(int i = nums.length - 1; i >=0; i --){
           if(i + nums[i] >= goal){
               goal = i;
           }
       }
       return (goal == 0);
    }

    public boolean canJumpGreedy(int[] nums) {
        int goal = nums.length - 1;
         for(int i = nums.length - 2; i >= 0; i --){
             if(i + nums[i] >=  goal){
                 goal = i;
             }
         }
         return goal == 0;
    }

    public boolean canJumpBackTracking(int[] nums){
        int index = 0;
        int jumpLength = nums[index];
        HashMap<Integer, Boolean> map = new HashMap<>();
        boolean canJump = canJumpBackTrackingHelper(nums, index, jumpLength, map);
        return canJump;
    }
    //{3,2,1,0,4}
    private boolean canJumpBackTrackingHelper(int[] nums, int index, int jumpLength, HashMap<Integer, Boolean> canJumpCache) {
        if(index >= nums.length - 1){
            return true;
        }
        if(jumpLength == 0){
            return false;
        }
        if(canJumpCache.containsKey(index)){
            System.out.println("accessing from cache"+index);
            return canJumpCache.get(index);
        }
        int maxJumpLength = nums[index];
        for(int i = 1; i <= maxJumpLength; i ++){
            if(canJumpBackTrackingHelper(nums, index + i, maxJumpLength, canJumpCache)){
                return true;
            }
        }
        System.out.println("putting into cache" + index + false);
        canJumpCache.put(index, false);
        return false;
    }

    public boolean canJumpRecursive(int[] nums){
        int index = 0;
        Boolean[] cache = new Boolean[nums.length];
        return canJumpRecursiveHelper(nums, index, cache);
    }
    //{3,2,1,0,4}
    private boolean canJumpRecursiveHelper(int[] nums, int index, Boolean[] cache) {
        if(index >= nums.length - 1){
            return true;
        }
        if(cache[index] != null){
            return cache[index];
        }
        int maxJump = nums[index];
        if(maxJump == 0){
            return false;
        }
        while(maxJump > 0){
            if(canJumpRecursiveHelper(nums, index+ maxJump, cache)){
                return true;
            }
            maxJump --;
        }
        return cache[index] = false;
    }

    public boolean canJump_BottomUp(int[] nums){
     boolean[] dp = new boolean[nums.length];
     dp[nums.length - 1] = true;
     for(int i = dp.length - 1; i >=0 ; i --){
         int maxSteps = nums[i];
         if(i + maxSteps >= dp.length - 1){
             dp[i] = true;
         }else{
             while(maxSteps > 0){
                 dp[i] = dp[i + maxSteps];
                 if(dp[i]){
                     break;
                 }
                 maxSteps --;
             }
         }
     }
     return dp[0];
    }
}
