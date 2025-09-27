package LeetCode.GraphExploreCard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OptimizeWaterDistributionInAVillage {
    public static void main(String[] args) {
        OptimizeWaterDistributionInAVillage optimizeWaterDistributionInAVillage = new OptimizeWaterDistributionInAVillage();
        int minCost = optimizeWaterDistributionInAVillage.minCostToSupplyWater(3, new int[]{1, 2, 2}, new int[][]{{1, 2, 1}, {2, 3, 1}});
        System.out.println(minCost);
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        int numOfConnectedComponents = n + 1;
        int minCost = 0;
        UnionFind unionFind = new UnionFind(n + 1);
        for (int i = 0; i < pipes.length; i++) {
            int[] pipe = pipes[i];
            minHeap.offer(pipe);
            System.out.println("inside pipes" + Arrays.toString(pipe));
        }
        for (int i = 0; i < wells.length; i++) {
            int[] well = new int[3];
            // we are considering well as a virtual node in our graph
            well[0] = 0;
            well[1] = i + 1;
            well[2] = wells[i];
            minHeap.offer(well);
        }

        while (!minHeap.isEmpty() && numOfConnectedComponents > 1) {
            int[] current = minHeap.poll();
            System.out.println(Arrays.toString(current));
            boolean isConnected = unionFind.isConnected(current[0], current[1]);
            if (isConnected) {
                continue;
            } else {
                unionFind.union(current[0], current[1]);
                minCost = minCost + current[2];
                numOfConnectedComponents--;
            }
        }

        if (numOfConnectedComponents > 1) {
            return -1;
        } else {
            return minCost;
        }
    }
}
