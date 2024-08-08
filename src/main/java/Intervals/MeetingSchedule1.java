package Intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingSchedule1 {
    public static void main(String[] args){

    }


    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0){
            return true;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int prevEnd = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i ++){
            int currentStart = intervals.get(i).start;
            if(! (prevEnd <= currentStart)){
                return false;
            }
            prevEnd = intervals.get(i).end;
        }
        return true;
    }
}
