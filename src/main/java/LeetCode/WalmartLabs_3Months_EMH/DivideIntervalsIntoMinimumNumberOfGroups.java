package LeetCode.WalmartLabs_3Months_EMH;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DivideIntervalsIntoMinimumNumberOfGroups {
    public static void main(String[] args){

    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] current = intervals[0];
        int currentStart = current[0];
        int currentEnd = current[1];
        minHeap.add(currentEnd);
        int numGroups = 1;
        for(int i = 1; i < intervals.length; i ++){
            current = intervals[i];
            currentStart = current[0];
            currentEnd = current[1];
            if(currentStart <= minHeap.peek()){
                numGroups++;
                minHeap.add(currentEnd);
            }else{
                minHeap.poll();
                minHeap.add(currentEnd);
            }
        }
        return numGroups;
    }
}
