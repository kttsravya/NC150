package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input =  {{1, 5}, {4, 6}, {6, 8}, {11, 15}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] res = mergeIntervals.mergeIntervals(input);
        for(int i = 0; i < res.length; i ++){
           System.out.println(Arrays.toString(res[i]));
        }
    }

    // this method assumes input is sorted
    public static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i ++){
            int[] current = intervals[i];
            // non-overlapping intervals
            if(current[0] > prev[1]){
                mergedIntervals.add(current);
                prev = current;
            }else{ // overlapping intervals
                prev[1] = Math.max(prev[1], current[1]);
            }
        }
        return mergedIntervals.toArray(new int[][]{});
    }

    // this method assumes input is not sorted
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
}
