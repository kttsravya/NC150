package LeetCode.AirBnb;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    private static Integer max = Integer.MIN_VALUE;
    public static void main(String[] args){
        int[] startTime = new int[]{4,2,4,8,2};
        int[] endTime = new int[]{5,5,5,10,8};
        int[] profit = new int[]{1,2,8,10,4};
        int max = jobScheduling(startTime, endTime, profit);
        System.out.println(max);
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] intervalList = new int[startTime.length][3];
        int[] memo = new int[startTime.length];
        Arrays.fill(memo, -1);

        for (int i = 0; i < startTime.length; i++) {
            int[] currentInterval = new int[3];
            currentInterval[0] = startTime[i];
            currentInterval[1] = endTime[i];
            currentInterval[2] = profit[i];
            intervalList[i] = currentInterval;
        }

        Arrays.sort(intervalList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] sortedStartTimes = new int[startTime.length];
        for(int i = 0; i < intervalList.length; i ++){
            sortedStartTimes[i] = intervalList[i][0];
        }

        int currentIndex = 0;
        return jobSchedulerHelper(currentIndex, intervalList, memo, sortedStartTimes);
    }

    private static int jobSchedulerHelper(int currentIndex, int[][] intervalList, int[] memo, int[] sortedStartTimes) {
        if (currentIndex == intervalList.length) {
            return 0;
        }
        if (memo[currentIndex] != -1) {
            return memo[currentIndex];
        }

        int[] currentInterval = intervalList[currentIndex];

        int nextValidPosition = findNextInterval(currentInterval[1], sortedStartTimes);
        System.out.println("next valid position is " + nextValidPosition);

        int max = Math.max(currentInterval[2] + jobSchedulerHelper(nextValidPosition, intervalList, memo, sortedStartTimes),
                jobSchedulerHelper(currentIndex + 1, intervalList, memo, sortedStartTimes));

         memo[currentIndex] = max;
         System.out.println(Arrays.toString(memo));
         return memo[currentIndex];
    }

    private static int findNextInterval(int currentIntervalEnd, int[] sortedStartTimes) {
        int start = 0;
        int end = sortedStartTimes.length - 1;
        int nextIndex = sortedStartTimes.length;
        while(start <= end){
            int mid = (start + end)/2;
            if(sortedStartTimes[mid] >= currentIntervalEnd){
                end = mid - 1;
                nextIndex = mid;
            }else{
                start = mid + 1;
            }
        }
        return nextIndex;
    }
}

/*class Solution {
    // maximum number of jobs are 50000
    int[] memo = new int[50001];

    private int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }

    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position) {
        // 0 profit if we have already iterated over all the jobs
        if (position == n) {
            return 0;
        }

        // return result directly if it's calculated
        if (memo[position] != -1) {
            return memo[position];
        }

        // nextIndex is the index of next non-conflicting job
        int nextIndex = findNextJob(startTime, jobs.get(position).get(1));

        // find the maximum profit of our two options: skipping or scheduling the current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, position + 1),
                jobs.get(position).get(2) + findMaxProfit(jobs, startTime, n, nextIndex));

        // return maximum profit and also store it for future reference (memoization)
        return memo[position] = maxProfit;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();

        // marking all values to -1 so that we can differentiate
        // if we have already calculated the answer or not
        Arrays.fill(memo, -1);

        // storing job's details into one list
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }

        return findMaxProfit(jobs, startTime, length, 0);
    }*/
//}


