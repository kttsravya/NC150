package LeetCode.LeetCodeWeeklyContest409;

import java.util.HashMap;
import java.util.Map;

public class NeighborSum {
    int[][] grid;
    Map<Integer, String> gridValuePositions;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        gridValuePositions = new HashMap<>();
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                gridValuePositions.put(grid[i][j], String.valueOf(i).concat(String.valueOf(j)));
            }
        }
    }

    public int adjacentSum(int value) {
        String position = gridValuePositions.get(value);
        int row = Character.getNumericValue(position.charAt(0));
        int col = Character.getNumericValue(position.charAt(1));
        return getNeighbor(row+1, col) + getNeighbor(row-1, col)+ getNeighbor(row, col-1)+ getNeighbor(row, col+1);

    }

    public int diagonalSum(int value) {
        String position = gridValuePositions.get(value);
        int row = Character.getNumericValue(position.charAt(0));
        int col = Character.getNumericValue(position.charAt(1));
        return getNeighbor(row-1, col-1) + getNeighbor(row-1, col+1)+ getNeighbor(row+1, col-1)+ getNeighbor(row+1, col+1);
    }

    private int getNeighbor(int row, int col){
        if(row < 0 || row > grid.length || col < 0 || col > grid[row].length){
            return 0;
        }
        return grid[row][col];
    }
}
