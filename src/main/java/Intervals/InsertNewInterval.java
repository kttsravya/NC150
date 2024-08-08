package Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertNewInterval {

    public static void main(String[] args) {
        InsertNewInterval insertNewInterval = new InsertNewInterval();
        int[][] result = insertNewInterval.insertInterval(new int[][]{{8, 10}, {12, 15}}, new int[]{10, 12});
        for (int i = 0; i < result.length; i++) {
            System.out.print("[ ");
            for(int j = 0; j < result[i].length; j ++){
                System.out.print(result[i][j] +" ");
            }
            System.out.print("]");
        }
    }

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval){
        List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;
        while(i < existingIntervals.length && existingIntervals[i][0] < newInterval[0]) {
            mergedIntervals.add(existingIntervals[i]);
            i++;
        }
        if(mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1)[1] < newInterval[0]) {
            mergedIntervals.add(newInterval);
        }else {
            int[] prev = mergedIntervals.get(mergedIntervals.size() - 1);
            prev[1] = Math.max(prev[1], newInterval[1]);
        }
        int[] prev = mergedIntervals.get(mergedIntervals.size() - 1);
        while(i < existingIntervals.length){
            int[] current = existingIntervals[i];
            if(prev[1] < current[0]){
                mergedIntervals.add(current);
                prev = current;
            }else{
                prev[1] = Math.max(prev[1], current[1]);
            }
            i++;
        }
        return mergedIntervals.toArray(new int[][]{});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            } else if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
