package Graph;

import org.junit.Assert;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
            CourseSchedule courseSchedule = new CourseSchedule();
            boolean canFin = courseSchedule.canFinish(2, new int[][]{{0,1}});
            Assert.assertEquals(true, canFin);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        // Create Adjacency Map
        for (int i = 0; i < prerequisites.length; i++) {
            int[] preRequisite = prerequisites[i];
            List<Integer> list = adjacencyMap.getOrDefault(preRequisite[0], new ArrayList<>());
            list.add(preRequisite[1]);
            adjacencyMap.put(preRequisite[0], list);
        }

        System.out.println("printing Adjacency map");
        printAdjacencyMap(adjacencyMap);

        // check if each course can be completed
        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> visited = new HashSet<>();
            boolean canFinish = canFinishHelper(i, visited, adjacencyMap);
            if (!canFinish) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinishHelper(int course, HashSet<Integer> visited,
                                    Map<Integer, List<Integer>> adjacencyMap) {
        List<Integer> dependencies = adjacencyMap.getOrDefault(course, new ArrayList<Integer>());
        if (visited.contains(course)) {
            //System.out.println("already visited");
            return false;
        }
        if (dependencies.isEmpty()) {
            return true;
        }
        visited.add(course);
        for (int i = 0; i < dependencies.size(); i++) {
            if (!canFinishHelper(dependencies.get(i), visited, adjacencyMap)) {
                return false;
            }
        }
        adjacencyMap.put(course,  new ArrayList<>());
        visited.remove(course);
        return true;
    }

    private void printAdjacencyMap(Map<Integer, List<Integer>> adjacencyMap) {
        for(int key: adjacencyMap.keySet()){
            System.out.println("key is " + key + " " + adjacencyMap.get(key).toString());
        }
    }
}
