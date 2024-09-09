package LeetCode.Intuit;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args){
        RottingOranges rottingOranges = new RottingOranges();
        int minMin = rottingOranges.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
        System.out.println(minMin);
    }


    private boolean isValid(int i, int j, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2){
            return false;
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        int level = -1;
        int freshOranges =0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
               if(grid[i][j] == 2){
                 queue.add(new int[]{i,j});
               }
               if(grid[i][j] == 1){
                   freshOranges ++;
               }
            }
        }
        while (! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                if(isValid(row+1, col, grid)){
                    grid[row+1][col] = 2;
                    freshOranges --;
                    queue.add(new int[]{row+1, col});
                }
                if(isValid(row-1, col, grid)){
                    grid[row-1][col] = 2;
                    freshOranges --;
                    queue.add(new int[]{row-1, col});
                }
                if(isValid(row, col-1, grid)){
                    grid[row][col-1] = 2;
                    freshOranges --;
                    queue.add(new int[]{row, col-1});
                }
                if(isValid(row, col+1, grid)){
                    grid[row][col+1] = 2;
                    freshOranges --;
                    queue.add(new int[]{row, col+1});
                }
                size --;
            }
            level = level + 1;
        }

        if(freshOranges > 0){
            return -1;
        }
        if(level > 0){
            return level-1;
        }else{
            return 0;
        }

    }
}
