package SortingAlgorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        QuickSort quickSort = new QuickSort();
        int[] input = {2,3,1,5,4};
        quickSort.quickSort(0, input.length - 1, input);
        System.out.println(Arrays.toString(input));
    }
    public void quickSort(int low, int high, int[] input){
        if(low < high){
            int pivotPosition = partition(input, low, high);
            quickSort(low, pivotPosition -1, input);
            quickSort(pivotPosition+1, high, input);
        }
    }

    private int partition(int[] input, int low, int high){
        int pivot = input[high];
        System.out.println("pivot is "+pivot);
        int pivotPosition = low;
        System.out.println("pivot position is "+ pivotPosition);
        for(int i = low; i < high; i ++){
            System.out.println("Inside For Loop");
            if(input[i] <= pivot){
                int temp = input[pivotPosition];
                input[pivotPosition] = input[i];
                input[i] = temp;
                pivotPosition ++;
            }
        }
        int temp = input[pivotPosition];
        input[pivotPosition] = pivot;
        input[high] = temp;
        return pivotPosition;
    }
}
