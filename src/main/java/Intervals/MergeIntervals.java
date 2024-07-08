package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input = {{9, 8}, {4, 2}, {8, 1}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] res = mergeIntervals.sortIntervalsStructuredDifferently(input);
        for(int i = 0; i < res.length; i ++){
           System.out.println(Arrays.toString(res[i]));
        }


    }

    public int[][] sortIntervalsStructuredDifferently(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i ++){
            int[] currentValue = intervals[i];
            int[] lastValue = result.get(result.size() - 1);
            if(currentValue[0] > lastValue[1]){
                result.add(currentValue);
            }else{
                result.remove(result.size() - 1);
                result.add(new int[]{lastValue[0], Math.max(lastValue[1], currentValue[1])});
            }
        }
        return result.toArray(new int[result.size()][]);
    }


    public int[][] sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] prev = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i ++){
            int[] current = intervals[i];
            if(prev == null){
                prev = intervals[i - 1];
            }

            // current element is not overlapping with previous element, hence
            // add prev element to result set and move to next element
            if(current[0] > prev[1]){
               list.add(prev);
               prev = null;
            }else{
                int[] mergeInterval = new int[]{Math.min(current[0], prev[0]), Math.max(current[1], prev[1])};
                prev = mergeInterval;
            }
        }
        if(prev == null){
            list.add(intervals[intervals.length - 1]);
        }else{
            list.add(prev);
        }
        return list.toArray(new int[list.size()][]);
    }

    /*public void mergeSort_2D(int[][] input, int low, int high) {
        if (input.length < 2) {
            return;
        }
        for (int i = 0; i < input.length; i++) {
            System.out.println("input" + Arrays.toString(input[i]));
        }
        int mid = (low + high) / 2;
        System.out.println("mid is " + mid);
        System.out.println("low is " + low);
        System.out.println("high is " + high);
        int[][] left = Arrays.copyOfRange(input, 0, mid);
        int[][] right = Arrays.copyOfRange(input, mid, high + 1);

       *//* for (int i = 0; i < left.length; i++) {
            left[i] = input[i];
        }*//*
        //print
        for (int i = 0; i < left.length; i++) {
            System.out.println("left side " + Arrays.toString(left[i]));
        }
        *//*for (int j = 0; j < right.length; j++) {
            right[j] = input[mid + j];
        }*//*
        //print
        for (int j = 0; j < right.length; j++) {
            System.out.println("right side " + Arrays.toString(right[j]));
        }
        mergeSort_2D(left, low, mid);
        mergeSort_2D(right, mid + 1, high);
        merge(left, right, input);
    }*/

   /* public void mergeSort(int[] input, int low, int high) {
        if (input.length < 2) {
            return;
        }
        int mid = (low + high) / 2;
        System.out.println("mid is " + mid);
        int[] left = new int[mid];
        int[] right = new int[high - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = input[i];
        }
        System.out.println(Arrays.toString(left));
        for (int j = 0; j < right.length; j++) {
            right[j] = input[mid + j];
        }
        System.out.println(Arrays.toString(right));
        mergeSort(left, low, mid);
        mergeSort(right, mid + 1, high);
        merge(left, right, input);
    }*/


    private void merge(int[][] left, int[][] right, int[][] input) {
        int leftPointer = 0;
        int rightPointer = 0;
        int inputPointer = 0;
        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer][0] <= right[rightPointer][0]) {
                input[inputPointer] = left[leftPointer];
                leftPointer++;
                inputPointer++;
            } else if (left[leftPointer][0] > right[rightPointer][0]) {
                input[inputPointer] = right[rightPointer];
                inputPointer++;
                rightPointer++;
            }
        }
        while (leftPointer < left.length) {
            input[inputPointer] = left[leftPointer];
            inputPointer++;
            leftPointer++;
        }
        while (rightPointer < right.length) {
            input[inputPointer] = right[rightPointer];
            inputPointer++;
            rightPointer++;
        }
    }
}
