package Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertNewInterval {

    public static void main(String[] args) {
        InsertNewInterval insertNewInterval = new InsertNewInterval();
        int[][] result = insertNewInterval.insert(new int[][]{{1, 2}, {3, 5}, {9, 10}}, new int[]{6, 7});
        for (int i = 0; i < result.length; i++) {
            System.out.print("[ ");
            for(int j = 0; j < result[i].length; j ++){
                System.out.print(result[i][j] +" ");
            }
            System.out.print("]");
        }
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
