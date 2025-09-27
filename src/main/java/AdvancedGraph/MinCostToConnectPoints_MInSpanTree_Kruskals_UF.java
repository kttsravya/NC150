package AdvancedGraph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectPoints_MInSpanTree_Kruskals_UF {
    public static void main(String[] args){
        MinCostToConnectPoints_MInSpanTree_Kruskals_UF minCost = new MinCostToConnectPoints_MInSpanTree_Kruskals_UF();
        int min = minCost.minCostConnectPoints(new int[][]{new int[]{0, 0},
        new int[]{2,2},
        new int[]{3,10},
        new int[]{5,2},
        new int[]{7, 0}
        });
        System.out.println(min);
    }

    public int minCostConnectPoints(int[][] points){
        UnionFind uf = new UnionFind(points.length);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < points.length; i ++){
            for(int j = i +1; j < points.length; j ++){
                int[] x = points[i];
                int[] y = points[j];
                int distance = Math.abs(x[0] - y[0]) + Math.abs(x[1]- y[1]);
                priorityQueue.offer(new int[]{distance, i, j});
                priorityQueue.offer(new int[]{distance, j, i});
            }
        }

        int targetNumOfVertices = points.length - 1;
        int counter = 0;
        int cost = 0;
        while(counter < targetNumOfVertices){
            int[] current = priorityQueue.poll();
            System.out.println("priority queue ordering" + Arrays.toString(current));
            if(! uf.isConnected(current[1], current[2])){
                uf.connect(current[1], current[2]);
                System.out.println("not connected" + Arrays.toString(current));
                cost = cost + current[0];
                counter = counter + 1;
            }else{
                continue;
            }
        }
        return cost;
    }
}
