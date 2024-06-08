package Graph;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class CountNumberOfIslands_BFS {
    public static void main(String[] args) {
        CountNumberOfIslands_BFS bfs = new CountNumberOfIslands_BFS();
        char[][] grid = {{'0', '1', '1', '1', '0'}, {'0', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int numIslands = bfs.numIslands(grid);
        Assert.assertEquals(1, numIslands);
        System.out.println(numIslands);
    }

    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    numOfIslands ++;
                    queue.add(new Cell(i, j));
                    numOfIslandsHelper(queue,visited, grid);
                }
            }
        }
        return numOfIslands;
    }

    private void numOfIslandsHelper(Queue<Cell> queue, int[][] visited, char[][] grid) {
        while (! queue.isEmpty()){
            Cell neigbhor = queue.poll();
            visited[neigbhor.row][neigbhor.col] = 1;
            int row = neigbhor.row;
            int col = neigbhor.col;
            if(row - 1 >= 0 && grid[row - 1][col] == '1' && visited[row - 1][col] != 1){
                queue.add(new Cell(row - 1, col));
            }
            if(row + 1 < grid.length && grid[row+1][col] == '1' && visited[row + 1][col] != 1){
                queue.add(new Cell(row + 1, col));
            }
            if(col - 1 >= 0 && grid[row][col - 1] == '1' && visited[row][col - 1] != 1){
                queue.add(new Cell(row, col-1));
            }
            if(col + 1 < grid[row].length && grid[row][col + 1] == '1' && visited[row][col + 1] != 1){
                queue.add(new Cell(row, col + 1));
            }
        }
    }
}

class Cell {
    int row;
    int col;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
