package LeetCode.AirBnb;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args){
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        int[] result = courseSchedule2.findOrder(1, new int[][]{});
        System.out.println(Arrays.toString(result));
    }
    // step 1: create adjacency list
    // step 2: perform DFS on each node in the list to find dependencies
    // step3: once end nodes is reached start add node to the result set and start traversing back.
    public int[] findOrder(int numCourses, int[][] prerequisites){
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
        // populate adjacency list
        for(int i = 0; i < prerequisites.length; i ++){
            int[] preRequisitePair = prerequisites[i];
            List<Integer> dependencies = adjacencyList.getOrDefault(preRequisitePair[0], new ArrayList<>());
            dependencies.add(preRequisitePair[1]);
            adjacencyList.put(preRequisitePair[0], dependencies);
        }

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> currentPath = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int currentCourse : adjacencyList.keySet()){
            if(! visited.contains(currentCourse)){
                if(! findOrderHelper(result, visited, currentPath, currentCourse, adjacencyList)){
                    return new int[]{};
                }
            }
        }
        if(result.size() < numCourses + 1){
            for(int i = 0; i < numCourses; i ++){
                if(!result.contains(i)){
                    result.add(i);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();

    }

    private boolean findOrderHelper(List<Integer> result, HashSet<Integer> visited, HashSet<Integer> currentPath, int currentCourse, Map<Integer, List<Integer>> adjacencyList) {
        if(currentPath.contains(currentCourse)){
            return false;
        }

        List<Integer> neighbors = adjacencyList.getOrDefault(currentCourse, new ArrayList<>());
        currentPath.add(currentCourse);
        for(int i = 0; i < neighbors.size(); i ++){
            int currentNeighbor = neighbors.get(i);
            if(visited.contains(currentNeighbor)){
                continue;
            }
            if(! findOrderHelper(result, visited, currentPath, currentNeighbor, adjacencyList)){
                return false;
            }
        }
        currentPath.remove(currentPath.size() - 1);
        result.add(currentCourse);
        visited.add(currentCourse);
        return true;
    }

}
