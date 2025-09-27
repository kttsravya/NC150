package LeetCode.Paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {
    public static void main(String[] args) {
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        Arrays.sort(slots1, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);

        int pointer1=0, pointer2=0;
        while(pointer1 < slots1.length && pointer2 < slots2.length){

            int intersectionLeft = Math.max(slots1[pointer1][0], slots2[pointer2][0]);
            int intersectionRight = Math.min(slots1[pointer1][1], slots2[pointer2][1]);
            if(intersectionRight - intersectionLeft >= duration){
                return new ArrayList<Integer>(Arrays.asList(intersectionLeft, intersectionRight));
            }
            // always move the one that ends earlier
            if(slots1[pointer1][1] < slots2[pointer2][1]){
                pointer1++;
            }else{
                pointer2++;
            }
        }
        return new ArrayList<Integer>();
    }
}
