package Graph;

import org.junit.Assert;

public class MaxAreaOfIsland_DFS {
    int maxAreaOfIsland = 0;

    public static void main(String[] args){
        MaxAreaOfIsland_DFS maxAreaOfIsland_dfs = new MaxAreaOfIsland_DFS();
        int[][] grid = {{0,1,1,0,1}, {1,0,1,0,1}, {0,1,1,0,1}, {0,1,0,0,1}};
        int[][] grid2 = {{1,1,1,1,1}};
        int maxArea = maxAreaOfIsland_dfs.maxAreaOfIsland_AltDFSApproach(grid);
        Assert.assertEquals(6, maxArea);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1 && visited[row][col] != 1) {
                    IslandArea islandArea = new IslandArea();
                    maxAreaOfIsland = Math.max(maxAreaOfIsland, MaxAreaOfIsland_DFS_Helper(grid, row, col, visited, islandArea));
                }
            }
        }
        return maxAreaOfIsland;
    }

    private int MaxAreaOfIsland_DFS_Helper(int[][] grid, int row, int col, int[][] visited, IslandArea islandArea) {
        visited[row][col] = 1;
        islandArea.setIslandArea(islandArea.getIslandArea() + 1);

        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            if (visited[row][col - 1] != 1) {
                MaxAreaOfIsland_DFS_Helper(grid, row, col - 1, visited, islandArea);
            }
        }

        if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
            if (visited[row][col + 1] != 1) {
                MaxAreaOfIsland_DFS_Helper(grid, row, col + 1, visited, islandArea);
            }
        }

        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            if (visited[row - 1][col] != 1) {
                MaxAreaOfIsland_DFS_Helper(grid, row - 1, col, visited, islandArea);
            }
        }

        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            if (visited[row + 1][col] != 1) {
                MaxAreaOfIsland_DFS_Helper(grid, row + 1, col, visited, islandArea);
            }
        }
        return islandArea.islandArea;
    }

    public int maxAreaOfIsland_AltDFSApproach(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1 && visited[row][col] != 1) {
                    maxAreaOfIsland = Math.max(maxAreaOfIsland, getMaxAreaOfIsland_AltDfsApproachHelper(grid, row, col, visited));
                }
            }
        }
        return maxAreaOfIsland;
    }

    private int getMaxAreaOfIsland_AltDfsApproachHelper(int[][] grid, int row, int col, int[][] visited){
        if(row < 0 || row  >= grid.length || col < 0 || col >= grid[row].length || visited[row][col] == 1 || grid[row][col] == 0){
            return 0;
        }
        visited[row][col] = 1;
        return 1 + getMaxAreaOfIsland_AltDfsApproachHelper(grid, row + 1, col, visited) +
        getMaxAreaOfIsland_AltDfsApproachHelper(grid, row - 1, col, visited)+
        getMaxAreaOfIsland_AltDfsApproachHelper(grid, row, col + 1, visited)+
        getMaxAreaOfIsland_AltDfsApproachHelper(grid, row, col - 1, visited);
    }


    class IslandArea {
        int islandArea;

        public IslandArea() {

        }

        public int getIslandArea() {
            return islandArea;
        }

        public void setIslandArea(int islandArea) {
            this.islandArea = islandArea;
        }
    }
}
