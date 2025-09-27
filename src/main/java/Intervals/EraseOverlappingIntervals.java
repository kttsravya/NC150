package Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlappingIntervals {
    public static void main(String[] args){
        EraseOverlappingIntervals eraseOverlappingIntervals = new EraseOverlappingIntervals();
        int eraseOverlap = eraseOverlappingIntervals.eraseOverlapIntervals_Greedy(new int[][]{{1,2},{2,4},{1,4}});
        System.out.println(eraseOverlap);
    }

    public int eraseOverlapIntervals_Greedy(int[][] intervals){
        int minOverlap = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i ++){
            if(intervals[i][0] < prevEnd){
                prevEnd = Math.min(intervals[i][1], prevEnd);
                minOverlap++;
            }else{
                prevEnd = intervals[i][1];
            }
        }
        return minOverlap;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int[][] cache = new int[intervals.length][intervals.length];
        for(int i = 0; i < cache.length; i ++){
            Arrays.fill(cache[i], -1);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        return intervals.length - eraseOverlapIntervalsHelper(intervals, 0, -1, cache);
    }

    private int eraseOverlapIntervalsHelper(int[][] intervals, int currentIndex, int prevIndex, int[][] cache) {
        //System.out.println(currentIndex);
        if(currentIndex == intervals.length){
            return 0;
        }
        if(prevIndex != -1 && cache[currentIndex][prevIndex] != -1){
            return cache[currentIndex][prevIndex];
        }
        int max = Integer.MIN_VALUE;
        if(prevIndex == -1 || intervals[prevIndex][1] <= intervals[currentIndex][0]){
            max = 1 + Math.max(max, eraseOverlapIntervalsHelper(intervals, currentIndex+1,  currentIndex, cache));
        }
        max = Math.max(max, eraseOverlapIntervalsHelper(intervals, currentIndex+1, prevIndex, cache));
        if(prevIndex != -1){
            cache[currentIndex][prevIndex] = max;
        }
        return max;
    }

}
