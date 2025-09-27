package LeetCode.GraphExploreCard;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public static void main(String[] args) {

    }

    public int earliestAcq(int[][] logs, int n) {
        UnionFind unionFind = new UnionFind(n);
        int numOfComponents = n;
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for (int i = 0; i < logs.length; i++) {
            int[] current = logs[i];
            if (!unionFind.isConnected(current[1], current[2])) {
                unionFind.union(current[1], current[2]);
                numOfComponents--;
            } else {
                unionFind.union(current[1], current[2]);
            }
            if (numOfComponents == 1) {
                return current[0];
            }
        }
       return -1;
    }
}
