package LeetCode.GraphExploreCard;

import java.util.*;

public class ValidTree {
    public static void main(String[] args){
        ValidTree validTree = new ValidTree();
        System.out.println(validTree.validTree_detectCycleInDirectedGraph(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind_ValidTree unionFind = new UnionFind_ValidTree(n);
        int numOfComponents = n;
        for(int i = 0; i < edges.length; i ++){
            int[] currentEdge = edges[i];
            if(unionFind.isConnected(currentEdge[0], currentEdge[1])){
                return false;
            }else{
                unionFind.union(currentEdge[0], currentEdge[1]);
                numOfComponents --;
            }
        }
        return numOfComponents == 1;
    }

    public boolean validTree_detectCycleInDirectedGraph(int n, int[][] edges){
        // step1: create Adjacency map
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for(int i = 0; i < n; i ++){
            adjacencyMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i ++){
            int[] edge = edges[i];

            List<Integer> neighbors = adjacencyMap.get(edge[0]);
            neighbors.add(edge[1]);

            List<Integer> otherNeighbors = adjacencyMap.get(edge[1]);
            otherNeighbors.add(edge[0]);

        }

        // step2: verify if visited node reappears again in current path.
        // Do DFS, and while doing DFS if visited node reappeared again, then cycle exist
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> currentPath = new HashSet<>();
        boolean isValid =  validTree_detectCycleInDirectedGraph(-1, currentPath, 0,
                                                                        visited, adjacencyMap);
        if(!isValid){
            return false;
        }
        if(visited.size() != n){
            return false;
        }
        return true;
    }

    private boolean validTree_detectCycleInDirectedGraph(Integer prev,
                                                         Set<Integer> cycle,
                                                         int current,
                                                         Set<Integer> visited,
                                                         Map<Integer,List<Integer>> adjacencyMap){
        if(cycle.contains(current)){
            return false;
        }
        cycle.add(current);
        List<Integer> neighbors = adjacencyMap.get(current);
        for(int i = 0; i < neighbors.size(); i ++){
            int neighbor = neighbors.get(i);
            if(neighbor == prev){
                continue;
            }
            if(!validTree_detectCycleInDirectedGraph(current, cycle, neighbor, visited, adjacencyMap)){
                return false;
            }
        }
        cycle.remove(current);
        visited.add(current);
        return true;
    }

}
