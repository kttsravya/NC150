package Graph;

import org.junit.Assert;

public class CountNumberOfIslands_DFS {
    public static void main(String[] args) {
        char[][] grid = {{'0', '1', '1', '1', '0'}, {'0', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
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
                    numOfIslands++;
                    exploreIsland(grid, row, col, visited);
                    printVisitedArray(visited);
                }
            }
        }
        return numOfIslands;
    }

    private void exploreIsland(char[][] grid, int row, int col, int[][] visited) {
        visited[row][col] = 1;

        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            if (visited[row][col - 1] != 1) {
                exploreIsland(grid, row, col - 1, visited);
            }
        }

        if (col + 1 < grid[row].length && grid[row][col + 1] == '1') {
            if (visited[row][col + 1] != 1) {
                exploreIsland(grid, row, col + 1, visited);
            }
        }

        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            if (visited[row - 1][col] != 1) {
                exploreIsland(grid, row - 1, col, visited);
            }
        }

        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
            if (visited[row + 1][col] != 1) {
                exploreIsland(grid, row + 1, col, visited);
            }
        }
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
}
