package Graph;

import java.util.*;

public class ValidTree_DetectCycleInUndirectedGraph {
    public static void main(String[] args){
        ValidTree_DetectCycleInUndirectedGraph isValidGraph = new ValidTree_DetectCycleInUndirectedGraph();
        boolean isValid = isValidGraph.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
        System.out.println(isValid);
    }

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        // step1: create Adjacency Map with empty neighbor list
        for(int i = 0; i < n; i ++){
            adjacencyList.put(i, new ArrayList<>());
        }
        // step2: populate neighbors
        for(int i = 0; i < edges.length; i ++){
            int[] edge = edges[i];
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        // step3: DFS on first node
        HashSet<Integer> cycle = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        int prev = -1;
        if(!validTreeHelper(0, adjacencyList, cycle, visited, prev)){
            return false;
        }
        if(visited.size() != n){
            return false;
        }
        return true;
    }

    private boolean validTreeHelper(int current, Map<Integer, List<Integer>> adjacencyMap,
                                    HashSet<Integer> cycle, HashSet<Integer> visited, int prev) {
        if(cycle.contains(current)){
            return false;
        }
        List<Integer> neighbors = adjacencyMap.get(current);
        cycle.add(current);
        for(int i = 0; i < neighbors.size(); i ++){
            int neighbor = neighbors.get(i);
            if(neighbor == prev ){
                continue;
            }
            if(!validTreeHelper(neighbor, adjacencyMap, cycle, visited, current)){
                return false;
            }
        }
        cycle.remove(current);
        visited.add(current);
        return true;
    }
}
