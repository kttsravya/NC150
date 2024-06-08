package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args){
        int[][] grid = {{2147483647,-1,0,2147483647},
                        {2147483647,2147483647,2147483647,-1},
                        {2147483647,-1,2147483647,-1},
                        {0,-1,2147483647,2147483647}};
        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.islandsAndTreasure(grid);
        for(int i = 0 ; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void islandsAndTreasure(int[][] grid) {

        for(int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[i].length; j ++){
                // we explore only if current cell is land
                if(grid[i][j] != -1 &&  grid[i][j] != 0){
                   grid[i][j]  =  getShortestDistanceToTreasureForCurrentCell(i, j, grid);
                }
            }
        }
        //System.out.println("Shortest distance" + getShortestDistanceToTreasureForCurrentCell(1, 1, grid));
    }

    private int getShortestDistanceToTreasureForCurrentCell(int i, int j, int[][] grid) {
        GridNode current = new GridNode(i, j);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<GridNode> queue = new LinkedList<>();
        queue.add(current);
        visited[i][j] = true;

        int level = 0;

        while(! queue.isEmpty()){
            int numOfNodesAtCurrentLevel = queue.size();
            for(int nodesAtCurrentLevel = 0; nodesAtCurrentLevel < numOfNodesAtCurrentLevel; nodesAtCurrentLevel ++){
                current = queue.poll();
                int row = current.row;
                int col = current.col;
                System.out.println("Visiting row "+ row + "col "+col);
                if(row + 1 < grid.length){
                    if(grid[row+ 1][col] == 0){
                        return level + 1;
                    }
                    if(grid[row + 1][col] != -1 && !visited[row + 1][col]){
                        visited[row + 1][col] = true;
                        queue.offer(new GridNode(row + 1, col));
                    }
                }
                if(row - 1 >= 0){
                    if(grid[row - 1][col] == 0){
                        System.out.println("level is " +level);
                        return level + 1;
                    }
                    if(grid[row - 1][col] != -1 && !visited[row - 1][col]){
                        visited[row - 1][col] = true;
                        queue.offer(new GridNode(row - 1, col));
                    }
                }

                if(col - 1 >= 0){
                    if(grid[row][col - 1] == 0){
                        return level + 1;
                    }
                    if(grid[row][col - 1] != -1 && !visited[row][col - 1]){
                        visited[row][col - 1] = true;
                        queue.offer(new GridNode(row, col - 1));
                    }
                }

                if(col + 1 < grid[row].length){
                    if(grid[row][col + 1] == 0){
                        return level + 1;
                    }
                    if(grid[row][col + 1] != -1 && !visited[row][col + 1]){
                        visited[row][col + 1] = true;
                        queue.offer(new GridNode(row, col + 1));
                    }
                }
            }
            level = level + 1;
        }
        return grid[i][j];
    }
}

class GridNode{
    int row;
    int col;
    public GridNode(int row, int col){
        this.row = row;
        this.col = col;
    }
}
