package AdvancedGraph;

import java.util.*;

public class MinCostToConnectPoints_MinSpanningTree_PrimsAlgo_Revision {
    public static void main(String[] args) {
        MinCostToConnectPoints_MinSpanningTree_PrimsAlgo_Revision minCost = new MinCostToConnectPoints_MinSpanningTree_PrimsAlgo_Revision();
        int minCostST = minCost.minCostConnectPoints(new int[][]{
                {0, 0},{1,1},{1,0},{-1,1}
        });
        System.out.println("MIN cost of spanning tree is "+ minCostST);

    }

    public int minCostConnectPoints(int[][] points) {
        /* create adjacency map (distance between current point to all other points ex: 0(key): (value) [4,1] [3,2],[2,3][5,4]
         * 4 denotes weight and 1 denotes node value, meaning distance between node 0 to 1 is 4
         * */
        HashMap<Integer, List<int[]>> adjacentMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int manhattanDistance = getManhattanDistance(point1, point2);
                List<int[]> listI = adjacentMap.getOrDefault(i, new ArrayList<>());
                listI.add(new int[]{manhattanDistance, j});
                adjacentMap.put(i, listI);

                List<int[]> listJ = adjacentMap.getOrDefault(j, new ArrayList<>());
                listJ.add(new int[]{manhattanDistance, i});
                adjacentMap.put(j, listJ);
            }
        }

        for(int key: adjacentMap.keySet()){
            System.out.print(key);
            List<int[]> list = adjacentMap.get(key);
            for(int i = 0; i < list.size(); i ++){
                System.out.print(Arrays.toString(list.get(i)));
            }
            System.out.println();
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        HashSet<Integer> visited = new HashSet<>();
        // seed node distance from node 0 to node 0 is 0
        minHeap.add(new int[]{0, 0});
        int cost = 0;

        while (! minHeap.isEmpty() && visited.size() < points.length) {
            int[] current = minHeap.poll();
            int currentCost = current[0];
            int nodeValue = current[1];
            if (visited.contains(nodeValue)) {
                continue;
            }
            System.out.println(Arrays.toString(current));
            cost = cost + currentCost;
            visited.add(nodeValue);
            List<int[]> listOfNeighborsAndThereCosts = adjacentMap.getOrDefault(nodeValue, new ArrayList<>());
            minHeap.addAll(listOfNeighborsAndThereCosts);
        }
        return cost;
    }

    private int getManhattanDistance(int[] point1, int[] point2) {
        int distance = Math.abs(point1[0] - point2[0]) +
                Math.abs(point1[1] - point2[1]);
        return distance;
    }

}
