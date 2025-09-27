package AdvancedGraph;

public class UnionFind {
    int[] rank;
    int[] root;
    public UnionFind(int numOfVertices){
        rank = new int[numOfVertices];
        root = new int[numOfVertices];
        for(int i = 0; i < rank.length; i ++){
            rank[i] = 1;
            root[i] = i;
        }
    }

    public int findRoot(int i){
        while(i != root[i]){
            i = root[i];
        }
        return i;
    }

    public void connect (int x, int y){
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if (rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootY]= rank[rootY] + 1;
            }
        }
    }

    public boolean isConnected(int x, int y){
        System.out.println("root of" + x + "is" + findRoot(x));
        System.out.println("root of" + y + "is" + findRoot(y));
        return findRoot(x) == findRoot(y);
    }
}
