package DynamicProgramming2D;

import java.util.Arrays;

public class CountPaths_PureDP_BottomUp {
    public static void main(String[] args) {
        CountPaths_PureDP_BottomUp countPaths_pureDP_bottomUp = new CountPaths_PureDP_BottomUp();
        int uniqueWays = countPaths_pureDP_bottomUp.uniquePathsWithMemoryOptimization(3, 6);
        System.out.println("totla unique ways " + uniqueWays);
    }

    public int uniquePaths(int m, int n) {
        int[][] uniquePath = new int[m][n];
        int row = m - 1;
        int col = n - 1;
        uniquePath[row][col] = 1;
        //printUniquePaths(uniquePath);
        for (int rows = uniquePath.length - 1; rows >= 0; rows--) {
            for (int cols = uniquePath[0].length - 1; cols >= 0; cols--) {
                int down = 0;
                int right = 0;
                if (rows + 1 < uniquePath.length) {
                    down = uniquePath[rows + 1][cols];
                }
                if (cols + 1 < uniquePath[0].length) {
                    right = uniquePath[rows][cols + 1];
                }
                if (uniquePath[rows][cols] == 0) {
                    uniquePath[rows][cols] = down + right;
                }
            }
            printUniquePaths(uniquePath);
        }
        //printUniquePaths(uniquePath);
        return uniquePath[0][0];
    }

    public int uniquePathsWithMemoryOptimization(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for (int j = n - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        return row[0];
    }


    private void printUniquePaths(int[][] uniquePath) {
        for (int i = 0; i < uniquePath.length; i++) {
            for (int j = 0; j < uniquePath[0].length; j++) {
                System.out.print(uniquePath[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
