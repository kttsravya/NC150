package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int minTime = rottingOranges.orangesRotting(new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 1, 2}});
        System.out.println(minTime);
    }

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }
                if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                System.out.print("current item " + row + " " + col);
                if (isValid(row + 1, col, grid) && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.offer(new int[]{row + 1, col});
                    fresh--;
                }
                if (isValid(row - 1, col, grid) && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.offer(new int[]{row - 1, col});
                    fresh--;
                }
                if (isValid(row, col + 1, grid) && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.offer(new int[]{row, col + 1});
                    fresh--;
                }
                if (isValid(row, col - 1, grid) && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.offer(new int[]{row, col - 1});
                    fresh--;
                }
            }
            System.out.println();
            time++;
            System.out.println("time is " + time);
        }
        return fresh > 0 ? -1 : time;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        return true;
    }

}
