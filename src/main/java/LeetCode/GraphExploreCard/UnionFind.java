package LeetCode.GraphExploreCard;
// Union Find with Ranking DataStructure Implementation
public class UnionFind {
    int[] root;
    // rank can be considered as height
    int[] rank;

    public UnionFind(int n){
        root = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i ++){
            root[i] = i; // setting root of the node as itself
            rank[i] = 1; // setting each node rank to 1
        }
    }

    // finds the root of the given node
    public int find(int node){
        while(node != root[node]){
            node = root[node];
        }
        return node;
    }

    // find with path compression
    /*public int find(int node){
        if(node == root[node]){
            return node;
        }
        return root[node] = find(root[node]);
    }*/

    public void union(int vertex1, int vertex2){
        int vertex1Root = find(vertex1);
        int vertex2Root = find(vertex2);
        if(vertex1Root != vertex2Root){
            if(rank[vertex1Root] > rank[vertex2Root]){
                root[vertex2Root] = vertex1Root;
            }else if(rank[vertex1Root] < rank[vertex2Root]){
                root[vertex1Root] = vertex2Root;
            }else{// both vertex1 and vertex2 heights are same
                root[vertex1Root] = vertex2Root;
                rank[vertex2Root] = rank[vertex2Root] + 1;
            }
        }
    }

    public boolean isConnected(int vertex1, int vertex2){
        return find(vertex1) == find(vertex2);
    }
}
