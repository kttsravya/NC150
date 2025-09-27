package Intervals;

import java.util.*;

// Leetcode editorial video
public class MeetingSchedule2 {
    public static void main(String[] args){
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(0,40));
        list.add(new Interval(5, 10));
        list.add(new Interval(15, 20));
        int num = MeetingSchedule2.minMeetingRooms(new ArrayList<>(list));
        System.out.println(num);
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0){
            return 0;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int numMeetingRooms = 0;
        PriorityQueue<Interval> minHeapByEnd = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });
        minHeapByEnd.add(intervals.get(0));
        numMeetingRooms ++;
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start < minHeapByEnd.peek().end){
                numMeetingRooms++;
                minHeapByEnd.add(current);
            }else{
                minHeapByEnd.poll();
                minHeapByEnd.add(current);
            }
        }
        return numMeetingRooms;
    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int numMeetingRooms = 0;
        PriorityQueue<int[]> minHeapByEnd = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        minHeapByEnd.add(intervals[0]);
        numMeetingRooms ++;
        for(int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            if(current[0] < minHeapByEnd.peek()[1]){
                numMeetingRooms++;
                minHeapByEnd.add(current);
            }else{
                minHeapByEnd.poll();
                minHeapByEnd.add(current);
            }
        }
        return numMeetingRooms;
    }

}

class Interval {
     public int start, end;
     public Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }
 }

