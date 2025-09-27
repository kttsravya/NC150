package InterviewPrep_2025.LeetCode.BitManipulation;

import java.util.Arrays;

// check this video - https://www.youtube.com/watch?v=UA5JnV1J2sI
// (take u forward)
public class SingleNumber3 {
    public static void main(String[] args){
        int[] nums = {0,1};
        int[] result = singleNumber(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] singleNumber(int[] nums) {
        int uniqueElements = 0;
        for (int i = 0; i < nums.length; i++) {
            uniqueElements = uniqueElements ^ nums[i];
        }
        // a & (-a) to preserve LSB set bit and make other zero
        int uniqueElementNegative = (~uniqueElements) + 1;
        int lastBitSetOnUniqueElements = uniqueElements & uniqueElementNegative;

        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lastBitSetOnUniqueElements) != 0) {
                x = x ^ nums[i];
            }
        }
        int y = uniqueElements ^ x;
        return new int[]{x, y};
    }
}
