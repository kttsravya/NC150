package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {
    public static void main(String[] args){
        IntervalListIntersection intervalListIntersection = new IntervalListIntersection();
        int[][] result = intervalListIntersection.intervalsIntersection(new int[][]{{1, 4}, {5, 6}, {9, 15}}, new int[][]{{2, 4}, {5, 7}, {9, 15}});
        for(int i = 0; i < result.length; i ++){
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        List<int[]> intersectionList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < intervalLista.length && j < intervalListb.length){
            int[] intervalA = intervalLista[i];
            int[] intervalB = intervalListb[j];

            int start = Math.max(intervalA[0], intervalB[0]);
            int end = Math.min(intervalA[1], intervalB[1]);

            if(start <= end){
                intersectionList.add(new int[]{start, end});
            }

            if(intervalA[1] < intervalB[1]){
                i++;
            }else{
                j++;
            }
        }
        return intersectionList.toArray(new int[][]{});
    }

}
