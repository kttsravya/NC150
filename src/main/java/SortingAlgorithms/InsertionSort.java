package SortingAlgorithms;

import java.util.Arrays;

/*
TimeComplexity is O(n^2) and stable sort algorithm, space complexity is constant. sort in place.
maintains two sets sorted and unsorted sets in an given array. as we traverse from left to right,
sorted/left set boundary increases and unsorted set length decreases.
As we iterate through the array, we place the current element in correct position by comparing current with (current-1) to 0.
and place it in correct position
 */
public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] input = {5, 3, 9, 1, 0, 44, 23, 90};
        sort.insertionSort(input);
        System.out.println(Arrays.toString(input));
    }

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            insertionSorHelper(nums, i);
        }
    }

    private void insertionSorHelper(int[] nums, int currentPointer) {
        int prevPointer = currentPointer - 1;
        while (prevPointer >= 0) {
            if (nums[currentPointer] < nums[prevPointer]) {
                int temp = nums[prevPointer];
                nums[prevPointer] = nums[currentPointer];
                nums[currentPointer] = temp;
            } else {
                break;
            }
            currentPointer = prevPointer;
            prevPointer = prevPointer - 1;

        }
    }
}
