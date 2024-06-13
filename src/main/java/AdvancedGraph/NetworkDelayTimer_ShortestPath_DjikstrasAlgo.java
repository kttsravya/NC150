package AdvancedGraph;

import java.util.*;

public class NetworkDelayTimer_ShortestPath_DjikstrasAlgo {
    public static void main(String[] args) {
       NetworkDelayTimer_ShortestPath_DjikstrasAlgo shortestPath = new NetworkDelayTimer_ShortestPath_DjikstrasAlgo();
       int[][] times = {{1, 2, 1}, {2, 3, 1}, {1, 4, 4}, {3, 4, 1}};
       int n = 4;
       int k = 1;
       int minShortestPath = shortestPath.networkDelayTime(times, n, k);
       System.out.println(minShortestPath);

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adjacencyMap = new HashMap<>();
        // create adjacency map
        for (int i = 0; i < times.length; i++) {
            int sourceNode = times[i][0];
            int destNode = times[i][1];
            int delay = times[i][2];

            List<int[]> adjacentNodeList = adjacencyMap.getOrDefault(sourceNode, new ArrayList<>());
            adjacentNodeList.add(new int[]{delay, destNode});
            adjacencyMap.put(sourceNode, adjacentNodeList);
        }

        //Implement Djikstras algorithm
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<Integer> visit = new ArrayList<>();
        int minDelay = 0;
        // add Initial node to the graph (0, k), adding first element to the graph costs 0 hence (0, k) k being the source node
        minHeap.offer(new int[]{0, k});

        while (!minHeap.isEmpty()) {
            int[] tuple = minHeap.poll();
            int delayFromSourceToCurrent = tuple[0];
            int current = tuple[1];
            if (visit.contains(current)) {
                continue;
            }
            minDelay = Math.max(minDelay, delayFromSourceToCurrent);
            List<int[]> neighborList = adjacencyMap.getOrDefault(current, new ArrayList<>());
            // add all neighbors/edges of the node to the minHeap. when adding delay add delay from source node the processing node in the below list
            for (int i = 0; i < neighborList.size(); i++) {
                int[] neighbor = neighborList.get(i);
                // below if is for optimization, algo works even without below condition
                if(! visit.contains(neighbor[1])){
                    minHeap.add(new int[]{delayFromSourceToCurrent + neighbor[0], neighbor[1]});
                }
            }
            visit.add(current);
        }
        if(visit.size() != n){return - 1;}
        return minDelay;
    }
}
