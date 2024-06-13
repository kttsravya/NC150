package Greedy;


import java.util.HashMap;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        boolean canJump = jumpGame.canJumpBackTracking(new int[]{3,2,1,0,4});
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
}
