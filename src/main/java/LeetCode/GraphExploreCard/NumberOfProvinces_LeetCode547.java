package LeetCode.GraphExploreCard;

public class NumberOfProvinces_LeetCode547 {
    public static void main(String[] args){
        NumberOfProvinces_LeetCode547 numOfProvinces = new NumberOfProvinces_LeetCode547();
        int numOfProv = numOfProvinces.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}});
        System.out.println(numOfProv);
    }


    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind(isConnected.length);
        int numOfComponents = isConnected.length;
        for(int i = 0; i < isConnected.length; i ++){
            for(int j = 0; j < isConnected[0].length; j ++){
                if(i == j){
                    continue;
                }else{
                   if(isConnected[i][j] == 1 && ! unionFind.isConnected(i, j)){
                       System.out.println("connect "+ i + " "+ j);
                       unionFind.union(i, j);
                       numOfComponents --;
                   }
                }
            }
        }
        return numOfComponents;
    }
}
