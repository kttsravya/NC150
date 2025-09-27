package LeetCode.GraphExploreCard;

public class NumberOfConnectedComponentsInAUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        int numOfComponents = n;
        for(int i = 0; i < edges.length; i ++){
            int[] edge = edges[i];
            if(! unionFind.isConnected(edge[0], edge[1])){
                unionFind.union(edge[0], edge[1]);
                numOfComponents --;
            }else{
                unionFind.union(edge[0], edge[1]);
            }
        }
        return numOfComponents;
    }

}
