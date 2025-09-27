package Graph;

import org.junit.Assert;

public class CountNumberOfIslands_DFS {
    public static void main(String[] args) {
        char[][] grid = {{'0', '1', '1', '1', '0'},
                         {'0', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};
        CountNumberOfIslands_DFS numberOfIslands = new CountNumberOfIslands_DFS();
        int num = numberOfIslands.numIslands(grid);
        Assert.assertEquals(1, num);
    }

    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int numOfIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && visited[row][col] != 1) {
                    exploreIsland(grid, row, col, visited);
                    numOfIslands++;
                    printVisitedArray(visited);
                }
            }
        }
        return numOfIslands;
    }

    private void exploreIsland(char[][] grid, int row, int col, int[][] visited) {
        if(row >= grid.length || row < 0 || col < 0 || col >= grid[0].length || grid[row][col] != '1' ||
        visited[row][col] == 1){
            return;
        }
        visited[row][col] = 1;
        exploreIsland(grid, row, col - 1, visited);
        exploreIsland(grid, row, col + 1, visited);
        exploreIsland(grid, row - 1, col, visited);
        exploreIsland(grid, row + 1, col, visited);
    }



    private void printVisitedArray(int[][] visited) {
        for(int i = 0; i < visited.length; i ++){
            for(int j = 0; j < visited[i].length; j ++){
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
        System.out.println("End");
    }
  // modified to find the area of island
   /* public int numIslandsRev(char[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        //int numOfIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    maxArea = Math.max(exploreIslandRevHelper(grid, row, col), maxArea);
                   // numOfIslands++;
                }
            }
        }
        return maxArea==Integer.MIN_VALUE? 0:maxArea;
    }

    private int exploreIslandRevHelper(char[][] grid, int row, int col) {
        if(row >= grid.length || row < 0 || col < 0 || col >= grid[0].length || grid[row][col] != '1'){
            return 0;
        }
        grid[row][col] = '0';

       return 1 + exploreIslandRevHelper(grid, row+1, col)+
           exploreIslandRevHelper(grid, row-1, col)+
           exploreIslandRevHelper(grid, row, col-1)+
           exploreIslandRevHelper(grid, row, col+1);
     }*/



}
