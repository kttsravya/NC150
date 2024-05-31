package SlidingWindow;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

// sliding window Fixed size
public class ContainsDuplicates_SlididngWIndow_FixedSize {

    // this solution compartes each element of the array with next k elements.
    // hence have nexted while loop.
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int iterator = 0;
        while (iterator < nums.length){
            int temp = iterator + 1;
            while(temp < nums.length && temp - iterator <= k){
                if(nums[iterator] == nums[temp]){
                    return true;
                }
                temp = temp + 1;
            }
            iterator ++;
        }
        return false;
    }

    //https://leetcode.com/problems/contains-duplicate-ii/solutions/5162542/java-sliding-window-solution-step-by-step-explanation/
    // Optimized solution using set.. in this approach we would solve the problem by just passing through each array element once instead of k times
    public boolean containsNearbyDuplicateUsingSet(int[] nums, int k) {
        Set<Integer> slidingWindow = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            if( i > k){
                slidingWindow.remove(nums[i - k - 1]);
            }
            if(! slidingWindow.add(nums[i])){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        ContainsDuplicates_SlididngWIndow_FixedSize cd = new ContainsDuplicates_SlididngWIndow_FixedSize();
        int[] nums = {1,2,3,1};
        int k = 3;
        boolean containsDuplicate = cd.containsNearbyDuplicateUsingSet(nums, k);
        Assert.assertTrue(containsDuplicate);
    }
}
