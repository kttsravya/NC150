package Graph;

public class NumberOfConnectedComponentsInUndirectedGraph_UnionFind {
    int[] representative;
    int[] size;
    public static void main(String[] args){
        NumberOfConnectedComponentsInUndirectedGraph_UnionFind numberOfConnComponents = new NumberOfConnectedComponentsInUndirectedGraph_UnionFind();
        int num = numberOfConnComponents.countComponents(5, new int[][]{{0,1}, {1,2}, {3,4}, {2,3}});
        System.out.println(num);
    }

    public int countComponents(int n, int[][] edges) {
        representative = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i ++){
            representative[i] = i;
            size[i] = 1;
        }
        int numOfConnectedComponents = n;
        for(int i = 0; i < edges.length; i ++){
            int[] currentEdge = edges[i];
            int rep1 = findRepresentative(currentEdge[0]);
            int rep2 = findRepresentative(currentEdge[1]);

            if(rep1 != rep2){
                if(size[rep1] >= size[rep2]){
                    size[rep1] = size[rep1] + size[rep2];
                    representative[rep2] = rep1;
                }else{
                    size[rep2] = size[rep1] + size[rep2];
                    representative[rep1] = rep2;
                }
                numOfConnectedComponents --;
            }
        }
        return numOfConnectedComponents;
    }

    private int findRepresentative(int vertex) {
        while(vertex != representative[vertex]){
            vertex = representative[vertex];
        }
        return vertex;
    }
}
