package Graph;

import org.junit.Assert;

public class IslandPerimeter {
    int perimeter = 0;

    public static void main(String[] args) {
        IslandPerimeter perimeter = new IslandPerimeter();
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int peri = perimeter.islandPerimeter(grid);
        Assert.assertEquals(16, peri);
    }


    public int islandPerimeter(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1 && visited[row][col] != 1) {
                    exploreIsland(grid, row, col, visited);
                }
            }
        }
        return perimeter;
    }

    private void exploreIsland(int[][] grid, int row, int col, int[][] visited) {
        int cellPerimeter = 4;

        visited[row][col] = 1;

        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            cellPerimeter = cellPerimeter - 1;
            if (visited[row][col - 1] != 1) {
                exploreIsland(grid, row, col - 1, visited);
            }
        }

        if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
            cellPerimeter = cellPerimeter - 1;
            if (visited[row][col + 1] != 1) {
                exploreIsland(grid, row, col + 1, visited);
            }
        }

        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            cellPerimeter = cellPerimeter - 1;
            if (visited[row - 1][col] != 1) {
                exploreIsland(grid, row - 1, col, visited);
            }
        }

        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            cellPerimeter = cellPerimeter - 1;
            if (visited[row + 1][col] != 1) {
                exploreIsland(grid, row + 1, col, visited);
            }
        }
        perimeter = perimeter + cellPerimeter;
    }
}
