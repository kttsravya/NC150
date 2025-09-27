package LeetCode.GraphExploreCard;

public class UnionFind_ValidTree {
    int[] root;
    int[] rank;

    public UnionFind_ValidTree(int numOfNodes){
        root = new int[numOfNodes];
        rank = new int[numOfNodes];
        for(int i = 0; i < root.length; i ++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    // given a node, finds the root.
    public int find(int nodeValue){
        while(nodeValue != root[nodeValue]){
            nodeValue = root[nodeValue];
        }
        return nodeValue;
    }

    // given a node, finds the root.
    public int find_WithPathCompression(int nodeValue){
        if(nodeValue == root[nodeValue]){
            return nodeValue;
        }
        return root[nodeValue] = find_WithPathCompression(root[nodeValue]);
    }

    public void union(int vertex1, int vertex2){
        int vertex1Root = find(vertex1);
        int vertex2Root = find(vertex2);
        if(vertex1Root != vertex2Root){
            if(rank[vertex2Root] > rank[vertex1Root]){
                root[vertex1Root] =  vertex2Root;
            }else if (rank[vertex2Root] < rank[vertex1Root]){
                root[vertex2Root] = vertex1Root;
            }else{ // both ranks are equal
                root[vertex2Root] = vertex1Root;
                rank[vertex1Root] = rank[vertex1Root] + 1;
            }
        }
    }


    public boolean isConnected(int vertex1, int vertex2){
        return find(vertex1) == find(vertex2);
    }

}
