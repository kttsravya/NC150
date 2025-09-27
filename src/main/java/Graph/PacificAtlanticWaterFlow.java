package Graph;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args){
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        List<List<Integer>> result = pacificAtlanticWaterFlow.pacificAtlantic(new int[][]{
                {4,2,7,3,4},
                {7,4,6,4,7},
                {6,3,5,3,6}});
        System.out.println(result.toString());
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();
        List<List<Integer>> pacificAtlanticList = new ArrayList<>();
        Set<Integer> pacificVisited = new HashSet<>();
        Set<Integer> atlanticVisited = new HashSet<>();
        int COLS = heights[0].length;
        for(int row = 0; row < heights.length; row ++){
            for(int col = 0; col < heights[row].length; col ++){
                if(row == 0 || col == 0){
                    pacificQueue.offer(new int[]{row, col, heights[row][col]});
                    pacificVisited.add(COLS*row+col);
                }
                if(row == heights.length - 1 || col == heights[row].length - 1){
                    atlanticQueue.offer(new int[]{row, col, heights[row][col]});
                    atlanticVisited.add(COLS*row+col);
                }
            }
        }

       int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pacificQueue.isEmpty()){
            int[] currentItem = pacificQueue.poll();
            int row = currentItem[0];
            int col = currentItem[1];
            for(int i = 0; i < directions.length; i ++){
                int r = row + directions[i][0];
                int c = col + directions[i][1];
                if(r >= 0 && r < heights.length && c >= 0 && c < heights[r].length && !pacificVisited.contains(COLS*r+c)
                        && heights[r][c] >= currentItem[2]){
                    pacificVisited.add(COLS*r+c);
                    pacificQueue.offer(new int[]{r, c, heights[r][c]});
                }
            }
        }


        while(!atlanticQueue.isEmpty()){
            int[] currentItem = atlanticQueue.poll();
            int row = currentItem[0];
            int col = currentItem[1];
            for(int i = 0; i < directions.length; i ++){
                int r = row + directions[i][0];
                int c = col + directions[i][1];
                if(r >= 0 && r < heights.length && c >= 0 && c < heights[r].length && !atlanticVisited.contains(COLS*r+c)
                        && heights[r][c] >= currentItem[2]){
                    atlanticVisited.add(COLS*r+c);
                    atlanticQueue.offer(new int[]{r, c, heights[r][c]});
                }
            }
        }

        System.out.println(pacificVisited.toString());
        System.out.println(atlanticVisited.toString());

        for(int i = 0; i < heights.length; i ++){
            for(int j = 0; j < heights[0].length; j ++){
                int coord = i*COLS+j;
                if(atlanticVisited.contains(coord) && pacificVisited.contains(coord)){
                    pacificAtlanticList.add(Arrays.asList(i, j));
                }
            }
        }
        return pacificAtlanticList;
    }
}
