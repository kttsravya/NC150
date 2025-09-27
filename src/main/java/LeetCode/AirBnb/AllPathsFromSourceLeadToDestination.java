package LeetCode.AirBnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceLeadToDestination {

    public static void main(String[] args){

        AllPathsFromSourceLeadToDestination allPaths = new AllPathsFromSourceLeadToDestination();
        int[][] edges = {{0,1},{1,1}};
        boolean isTrue = allPaths.leadsToDestination(2,  edges, 0, 1);
        System.out.println(isTrue);

    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for(int i = 0; i < edges.length; i ++){
            int[] edge = edges[i];
            List<Integer> destinations = adjacencyMap.getOrDefault(edge[0], new ArrayList<>());
            destinations.add(edge[1]);
            adjacencyMap.put(edge[0], destinations);
        }
        List<Integer> currentPath = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        return leadsToDestinationHelper(adjacencyMap, source, destination, currentPath, visited);
    }

    private boolean leadsToDestinationHelper(Map<Integer, List<Integer>> adjacencyMap, int source, int destination, List<Integer> currentPath, List<Integer> visited) {
        currentPath.add(source);
        if(source == destination && adjacencyMap.getOrDefault(destination, new ArrayList<>()).size() == 0){
            return true;
        }
        if(visited.contains(source)){
            return true;
        }
        List<Integer> neighbors = adjacencyMap.getOrDefault(source, new ArrayList<>());
        if(neighbors.size() == 0){
            return false;
        }
        for(int i = 0; i < neighbors.size(); i ++){
            if(currentPath.contains(neighbors.get(i))){
                return false;
            }
            if(! leadsToDestinationHelper(adjacencyMap, neighbors.get(i), destination, currentPath, visited)){
                return false;
            }
            currentPath.remove(currentPath.size() - 1);
        }
        visited.add(source);
        return true;
    }
}
