package LeetCode.LeetCodeWeeklyContest409;

import java.util.*;

public class ShortestDistanceAfterRoadAdditionQuery1 {
    Map<Integer, List<Integer>> adjacencyMap;

    public static void main(String[] args){
        ShortestDistanceAfterRoadAdditionQuery1 shortestDistanceAfterRoadAdditionQuery1 = new ShortestDistanceAfterRoadAdditionQuery1();
        int[] res = shortestDistanceAfterRoadAdditionQuery1.shortestDistanceAfterQueries(5, new int[][]{{2,4},{0,2},{0,4}});
        System.out.println(Arrays.toString(res));

    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        createAdjacencyMap(n);
        printAdjacencyMap();
        List<Integer> result = new ArrayList<>();
        int[] cache = new int[n];
        for(int i = 0; i < queries.length; i ++){
            int[] connection = queries[i];
            adjacencyMap.get(connection[0]).add(connection[1]);
            Arrays.fill(cache, -1);
            result.add(getShortestDistanceHelper(0, n-1,cache));
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void printAdjacencyMap() {
        for(Integer src : adjacencyMap.keySet()){
            System.out.print(src + "value is "+ adjacencyMap.get(src));
        }
    }

    private Integer getShortestDistanceHelper(int current, int dest, int[] cache) {
        if(current == dest){
            return 0;
        }
        if(cache[current] != -1){
            return cache[current];
        }
        int minDistance = Integer.MAX_VALUE;
        List<Integer> neighbors = adjacencyMap.get(current);
        for(int i = 0; i < neighbors.size(); i ++){
           minDistance = Math.min(minDistance, 1+ getShortestDistanceHelper(neighbors.get(i), dest, cache));
        }
        return cache[current] = minDistance;
    }

    private void createAdjacencyMap(int n) {
        this.adjacencyMap = new HashMap<>();
        for(int i = 0; i <= n - 2; i ++){
            List<Integer> neighborList = new ArrayList<>();
            neighborList.add(i+1);
            adjacencyMap.put(i, neighborList);
        }

    }
}
