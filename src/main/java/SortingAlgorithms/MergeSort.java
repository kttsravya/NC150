package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    //similar implementation can be found in https://www.baeldung.com/java-merge-sort
    // idea is to get left subarray and right subarray to be sorted
    // then use merge function that takes sorted subarrays and create sorted array.

    // TimeComplexity is O(n * logn)
    // divide and conquer divides the array into half at each level and maximum height of the binary tree is O(log n) and
    // at each level through merge method you access all the elements in input array which contributes to n. hence O(n*logn)

    // Space complexity is O(n), at each level you create temp arrays in the process of divide and conquer method.
    public void sortArrayUsingMergeSort(int[] randomIntegers){
        mergeSort(randomIntegers);
    }

    private void mergeSort(int[] randomIntegers) {
        System.out.println(Arrays.toString(randomIntegers));
        if(randomIntegers.length < 2){
            return;
        }
        int midPoint = randomIntegers.length/2;
        int[] leftSubArray = Arrays.copyOfRange(randomIntegers, 0, midPoint);
        int[] rightSubArray = Arrays.copyOfRange(randomIntegers, midPoint, randomIntegers.length);
        mergeSort(leftSubArray);
        mergeSort(rightSubArray);
        // this method takes two sorted subarray and merge them. leftSubArray and rightSubArray are two sorted subarrayes.
        merge(randomIntegers, leftSubArray, rightSubArray);
    }

    private void merge(int[] randomIntegers, int[] leftSubArray, int[] rightSubArray) {
            int i = 0, j=0, k=0;
            int leftSubArrayLength = leftSubArray.length;
            int rightSubArrayLength = rightSubArray.length;
            while(i < leftSubArrayLength && j < rightSubArrayLength) {
             if(leftSubArray[i] <= rightSubArray[j]){
                 randomIntegers[k] = leftSubArray[i];
                 i ++;
                 k++;
             }else{
                 randomIntegers[k] = rightSubArray[j];
                 j ++;
                 k++;
             }
        }
         while(i < leftSubArrayLength){
             randomIntegers[k] = leftSubArray[i];
             i ++;
             k++;
         }
         while(j < rightSubArrayLength){
             randomIntegers[k] = rightSubArray[j];
             j++;
             k++;
         }
    }

    public static void main(String[] args){
        int[] randomIntegers = {-1, 25, 10000, -4, 33, -77, -98, 234, 587, 443};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortArrayUsingMergeSort(randomIntegers);
        System.out.println("Sorted Array is "+ Arrays.toString(randomIntegers));
    }
}
