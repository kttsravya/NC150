package ArraysAndHashing;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateIntegers {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> uniqueNumberSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i ++){
            if(! uniqueNumberSet.contains(nums[i])){
                uniqueNumberSet.add(nums[i]);
            }else{
                System.out.println("number:{"+ nums[i]+"} is duplicate");
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicateUsingSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i ++){
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        DuplicateIntegers di = new DuplicateIntegers();
        boolean hasDuplicates = di.hasDuplicate(new int[]{1, 2, 3});
        Assert.assertFalse(hasDuplicates);
        System.out.println(hasDuplicates);

        hasDuplicates = di.hasDuplicate(new int[]{1, 2, 3, 3});
        Assert.assertTrue(hasDuplicates);
        System.out.println(hasDuplicates);

        hasDuplicates = di.hasDuplicateUsingSort(new int[]{1, 2, 3, 3});
        Assert.assertTrue(hasDuplicates);
        System.out.println(hasDuplicates);
    }
}
