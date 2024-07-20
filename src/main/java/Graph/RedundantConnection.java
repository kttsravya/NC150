package Graph;

import java.util.*;

public class RedundantConnection {
    int[] representative;
    int[] size;
    int numOfConnectedComponents;
    public static void main(String[] args){
        RedundantConnection redundantConnection = new RedundantConnection();
        int[] redConn = redundantConnection.findRedundantConnection(new int[][]{{1,2},{1,3},{1,4},{3,4},{4,5}});
        System.out.println(Arrays.toString(redConn));
    }
   /* public int[] findRedundantConnection(int[][] edges){
        int numOfVertices = edges.length;
        representative = new int[numOfVertices + 1];
        size = new int[numOfVertices + 1];
        numOfConnectedComponents = numOfVertices;

        for(int i = 1; i < numOfVertices + 1; i ++){
            representative[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < edges.length; i ++){
            int[] edge = edges[i];
            int rep1 = findRepresentative(edge[0]);
            int rep2 = findRepresentative(edge[1]);
            if(rep1 != rep2){
                if(size[rep1] >= size[rep2]){
                    size[rep1] = size[rep1] + size[rep2];
                    representative[rep2] = rep1;
                }else{
                    size[rep2] = size[rep2]+ size[rep1];
                    representative[rep1] = rep2;
                }
                numOfConnectedComponents -- ;
            }else{
                return edge;
            }
        }
        return new int[]{-1, -1};
    }
*/
    public int[] findRedundantConnection(int[][] edges){
        int numOfVertices = edges.length;
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
        // create empty adjacencyMap
        for(int i = 0 ; i < edges.length + 1; i ++){
            adjacentMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i ++){
            int[] edge = edges[i];
            boolean[] visited = new boolean[numOfVertices + 1];
            boolean canConnect = canConnect(adjacentMap, edge[0], edge[1], visited);
            if(canConnect){
                return edge;
            }
            adjacentMap.get(edge[0]).add(edge[1]);
            adjacentMap.get(edge[1]).add(edge[0]);
        }
        return new int[]{-1, -1};
    }

    private boolean canConnect(Map<Integer, List<Integer>> adjacentMap, int source, int target, boolean[] visited) {
        if(source == target || visited[target]){
            return true;
        }
        visited[source] = true;
        List<Integer> neighbors = adjacentMap.get(source);
        for(int i = 0; i < neighbors.size(); i++){
            int neighbor = neighbors.get(i);
           if(! visited[neighbor] && canConnect(adjacentMap, neighbor, target , visited)){
               return true;
           }
        }
       return false;
    }

    private int findRepresentative(int vertex) {
        while(vertex != representative[vertex]){
            vertex = representative[vertex];
        }
        return vertex;
    }
}
