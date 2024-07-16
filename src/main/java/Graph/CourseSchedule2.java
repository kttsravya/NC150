package Graph;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args){
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        int[] res = courseSchedule2.findOrder(3, new int[][]{{1,0}});
        System.out.println(Arrays.toString(res));
    }

   /* public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<Integer, List<Integer>>();
        List<Integer> courseOrdering = new ArrayList<>();

        // initialize all nodes with empty neighbor list
        for(int i = 0; i < numCourses; i ++){
            List<Integer> list = new ArrayList<>();
            adjacencyMap.put(i, list);
        }
        // create an adjacent list
        for(int i = 0; i < prerequisites.length; i ++){
            int[] preRequisite = prerequisites[i];
           List<Integer> adjacencyList =  adjacencyMap.get(preRequisite[0]);
           adjacencyList.add(preRequisite[1]);
        }
        // traverse through all the nodes and perform DFS on each node
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i ++){
            if(!findOrderHelper(i, adjacencyMap, visited, courseOrdering)){
                return new int[]{};
            }
        }
        return courseOrdering.stream().mapToInt(i -> i).toArray();
    }

    private boolean findOrderHelper(int courseNumber, HashMap<Integer, List<Integer>> adjacencyMap,
                                 HashSet<Integer> visited, List<Integer> courseOrdering) {
        if(visited.contains(courseNumber)){
            return false;
        }
        if(adjacencyMap.get(courseNumber).isEmpty() && !courseOrdering.contains(courseNumber)){
            courseOrdering.add(courseNumber);
            return true;
        }
        visited.add(courseNumber);
        List<Integer> neighbours = adjacencyMap.get(courseNumber);
        for(int i = 0; i < neighbours.size(); i ++){
            if(!findOrderHelper(neighbours.get(i), adjacencyMap, visited, courseOrdering)){
                return false;
            }
        }
        if(!courseOrdering.contains(courseNumber)){
            courseOrdering.add(courseNumber);
        }
        visited.remove(courseNumber);
        adjacencyMap.put(courseNumber, new ArrayList<>());
        return true;
    }*/

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<Integer, List<Integer>>();

        // initialize all nodes with empty neighbor list
        for(int i = 0; i < numCourses; i ++){
            List<Integer> list = new ArrayList<>();
            adjacencyMap.put(i, list);
        }
        // create an adjacent list
        for(int i = 0; i < prerequisites.length; i ++){
            int[] preRequisite = prerequisites[i];
            List<Integer> adjacencyList =  adjacencyMap.get(preRequisite[0]);
            adjacencyList.add(preRequisite[1]);
        }
        // traverse through all the nodes and perform DFS on each node
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cycle = new HashSet<>();
        List<Integer> courseOrdering = new ArrayList<>();

        for(int i = 0; i < numCourses; i ++){
            if(!findOrderHelperWithVisitCycleOutput(i, adjacencyMap, visited, cycle, courseOrdering)){
                return new int[]{};
            }
        }
        return courseOrdering.stream().mapToInt(i -> i).toArray();
    }

    private boolean findOrderHelperWithVisitCycleOutput(int courseNumber, HashMap<Integer, List<Integer>> adjacencyMap,
                                    HashSet<Integer> visited, HashSet<Integer> cycle, List<Integer> courseOrdering) {

        // cycle contains nodes in current path
        if(cycle.contains(courseNumber)){
            return false;

        }
        // visited contains nodes already explored before and explored its dependencies, no need to explore again
        if(visited.contains(courseNumber)){
            return true;
        }

        cycle.add(courseNumber);
        List<Integer> neighbours = adjacencyMap.get(courseNumber);
        for(int i = 0; i < neighbours.size(); i ++){
            if(!findOrderHelperWithVisitCycleOutput(neighbours.get(i), adjacencyMap, visited, cycle, courseOrdering)){
                return false;
            }
        }
        cycle.remove(courseNumber);
        visited.add(courseNumber);
        courseOrdering.add(courseNumber);
        return true;
    }






















}
