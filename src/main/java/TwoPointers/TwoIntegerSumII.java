package TwoPointers;

import java.util.Arrays;

public class TwoIntegerSumII {
    public static void main(String[] args) {
        int[] numbers = {-150, -90, -75, 75, 150};
        int target = 75;
        TwoIntegerSumII twoIntegerSumII = new TwoIntegerSumII();
        int[] res = twoIntegerSumII.twoSum(numbers, target);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum(int[] numbers, int target) {
        int minPointer = 0;
        int maxPointer = numbers.length - 1;
        while (minPointer < maxPointer) {
            if (numbers[minPointer] + numbers[maxPointer] == target) {
                return new int[]{minPointer + 1, maxPointer + 1};
            } else if (numbers[minPointer] + numbers[maxPointer] < target) {
                minPointer++;
            } else {
                maxPointer--;
            }
        }
        return new int[]{-1, -1};
    }
}
