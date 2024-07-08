package AdvancedGraph;

import java.util.*;

public class MinCostToConnectPoints_MinSpanningTree_PrimsAlgo {
    public static void main(String[] args) {
        MinCostToConnectPoints_MinSpanningTree_PrimsAlgo minCost = new MinCostToConnectPoints_MinSpanningTree_PrimsAlgo();
        int minCostST = minCost.minCostConnectPoints(new int[][]{
                {0, 0}
        });
        System.out.println("MIN cost of spanning tree is "+ minCostST);
    }

    public int minCostConnectPoints(int[][] points) {
        // create adjacency map -
        // creating edges(distance between current node to other node) between nodes
        Map<Integer, List<Tuple>> adjacencyMap = new HashMap<>();
        List<Integer> visited = new ArrayList<>();
        int totalDistance = 0;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[j][0] - points[i][0]) +
                        Math.abs(points[j][1] - points[i][1]);
                List<Tuple> adjacencyList1 = adjacencyMap.getOrDefault(i, new ArrayList<>());
                adjacencyList1.add(new Tuple(distance, j));
                adjacencyMap.put(i, adjacencyList1);

                List<Tuple> adjacencyList2 = adjacencyMap.getOrDefault(j, new ArrayList<>());
                adjacencyList2.add(new Tuple(distance, i));
                adjacencyMap.put(j, adjacencyList2);
            }
        }

        // Executing Prim's Algorithm to find minimum cost spanning tree.
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        });

        // adding first node to the graph. first node is 0. adding first node to the graph costs 0. hence (0,0)
        minHeap.add(new Tuple(0, 0));


        while (visited.size() < points.length) {
            Tuple currentNode = minHeap.poll();
            if (visited.contains(currentNode.node)) {
                continue;
            }
            totalDistance = totalDistance + currentNode.distance;
            visited.add(currentNode.node);
            // add all the edges of the current node to heap. once added, popping an element from min heap return node
            // with shortest distance from current node.
            List<Tuple> adjacentNodes = adjacencyMap.getOrDefault(currentNode.node, new ArrayList<>());
            for (int i = 0; i < adjacentNodes.size(); i++) {
                minHeap.add(adjacentNodes.get(i));
            }

        }
        return totalDistance;
    }

    class Tuple {
        int distance;
        int node;

        public Tuple(int distance, int tuple) {
            this.distance = distance;
            this.node = tuple;
        }
    }
}
