package LeetCode.Intuit;

import java.util.*;
// TODO: topological sorting
public class TopologicalSorting {

    public static void main(String[] args){

    }

    public int[] findOrder(int numCourses, int[][] preRequisites){
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> currentPath = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // initializing map with all the neighbors
        for(int i = 0; i < numCourses ; i ++){
            adjacencyMap.put(i, new ArrayList<>());
        }

        // create a neighbor map
        for(int i = 0; i < preRequisites.length; i ++){
            int[] current = preRequisites[i];
            adjacencyMap.get(current[0]).add(current[1]);
        }

        for(Integer current : adjacencyMap.keySet()){
           if(visited.contains(current)){
               continue;
           }
           if(visited.size() < numCourses){
               findOrderHelper(adjacencyMap, visited, currentPath, result, current);
           }
        }
        if(result.size() == numCourses){
            return result.stream().mapToInt(i-> i).toArray();
        }else{
            return new int[]{};
        }
    }

    private void findOrderHelper(Map<Integer, List<Integer>> adjacencyMap, Set<Integer> visited, List<Integer> currentPath, List<Integer> result, int currentNode) {
        List<Integer> neighbors = adjacencyMap.get(currentNode);
        for(int neighbor : neighbors){

        }



    }
}
