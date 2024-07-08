package HeapsAndPriorityQueue;

import java.util.*;

public class TaskScheduling {
    public static void main(String[] args){
        TaskScheduling taskScheduling = new TaskScheduling();
        int time = taskScheduling.leastInterval(new char[]{'A','A','A','B','C'}, 3);
        System.out.println(time);
    }
    public int leastInterval(char[] tasks, int n) {
        Arrays.sort(tasks);
        List<Integer> list = new ArrayList<>();
        getFrequency(list, tasks);
        PriorityQueue<Integer> taskScheduler = new PriorityQueue<>(Comparator.reverseOrder());

        //todo: check how array deque is different from linkedlist
        Queue<int[]> queue = new ArrayDeque<>();
        taskScheduler.addAll(list);
        int time = 0;
        while (! taskScheduler.isEmpty() || ! queue.isEmpty()) {
            Integer item = taskScheduler.poll();
            time = time + 1;
            System.out.println("item "+ item + "completed at " + time);
            if (item != null) {
                item--;
                if (item > 0) {
                    queue.offer(new int[]{item, time + n});
                }
            }
            if (queue.peek() != null && queue.peek()[1] <= time) {
                int[] peeked = queue.poll();
                taskScheduler.offer(peeked[0]);
            }
        }
        System.out.println(Arrays.toString(tasks));
        System.out.println(list.toString());
        return time;
    }

    private void getFrequency(List<Integer> list, char[] tasks) {
        int counter = 1;
        for(int i = 1; i < tasks.length; i ++){
            if(tasks[i] == tasks[i - 1]){
                counter ++;
            }else{
                list.add(counter);
                counter = 1;
            }
        }
        list.add(counter);
    }
}
