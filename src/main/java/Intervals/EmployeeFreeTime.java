package Intervals;

import java.util.*;

public class EmployeeFreeTime {
    public static void main(String[] args) {
        List<int[]> list1 = new ArrayList<>();
        list1.add(new int[]{1,2});
        list1.add(new int[]{5,6});
        List<int[]> list2 = new ArrayList<>();
        list2.add(new int[]{1,3});
        List<int[]> list3 = new ArrayList<>();
        list3.add(new int[]{4,10});

        List<List<int[]>> schedules = new ArrayList<>();
        schedules.add(list1);
        schedules.add(list2);
        schedules.add(list3);
        List<int[]> res = EmployeeFreeTime.employeeFreeTime(schedules);
        for(int i = 0; i < res.size(); i ++){
            System.out.println(Arrays.toString(res.get(i)));
        }
    }

    // consider all schedules belongs to the same employee
    // and sort all items
    // merge overlapping intervals
    // then find free time
    public static List<int[]> employeeFreeTime(List<List<int[]>> schedule) {
        List<int[]> all = new ArrayList<>();
        List<int[]> freeTime = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        for (List<int[]> employee : schedule) {
            all.addAll(employee);
        }
        Collections.sort(all, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        freeTime.add(all.get(0));
        int[] prev = all.get(0);
        for (int i = 1; i < all.size(); i++) {
            int[] current = all.get(i);
            if (prev[1] < current[0]) {
                freeTime.add(current);
                prev = current;
            } else {
                prev[1] = Math.max(prev[1], current[1]);
            }
        }

        prev = freeTime.get(0);
        for (int i = 1; i < freeTime.size(); i++) {
            int[] current = freeTime.get(i);
            if (current[0] > prev[1]) {
                result.add(new int[]{prev[1], current[0]});
            }
        }
        return result;
    }
}
