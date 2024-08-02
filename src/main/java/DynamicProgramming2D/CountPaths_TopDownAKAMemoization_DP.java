package DynamicProgramming2D;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountPaths_TopDownAKAMemoization_DP {
    public static void main(String[] args){
        CountPaths_TopDownAKAMemoization_DP countPaths = new CountPaths_TopDownAKAMemoization_DP();
        int uniqueNumOfWays = countPaths.uniquePaths_Revision(3, 6);
        System.out.println(uniqueNumOfWays);
    }

    public int uniquePaths_Revision(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[m-1], 1);
        for(int i = dp.length - 2; i >=0; i--){
            Arrays.fill(dp[i], 1);
            for(int j = dp[i].length - 2; j >= 0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

   /*public int uniquePaths(int m, int n) {
       int row = 0;
       int col = 0;
       HashMap<Index, Integer> uniqueWaysCountMap = new HashMap<>();
       long start = System.currentTimeMillis();
       int numWays =  uniquePathsHelperWithDPMemoization(row, col, m - 1, n - 1, uniqueWaysCountMap);
       long end = System.currentTimeMillis();
       System.out.println("total time taken " + (end - start)/1000 + "seconds") ;
       return numWays;
   }

   private int uniquePathsHelperWithDPMemoization(int row, int col, int m, int n, Map<Index, Integer> uniqueWaysCountMap) {
       if( row > m || col > n ){
           return 0;
       }
       if(row == m && col == n){
           return 1;
       }
       if(uniqueWaysCountMap.containsKey(new Index(row, col))){
           System.out.println("retrieving from cache");
           return uniqueWaysCountMap.get(new Index(row, col));
       }
       int uniqueWays =  uniquePathsHelperWithDPMemoization(row, col + 1, m, n, uniqueWaysCountMap) + uniquePathsHelperWithDPMemoization(row + 1, col, m, n, uniqueWaysCountMap);
        System.out.println("putting into cache");
       uniqueWaysCountMap.put(new Index(row, col), uniqueWays);
       return uniqueWays;
   }
*/
    public int uniquePaths_RecursionWithCache(int m, int n) {
        int row = 0;
        int col = 0;
        int[][] cache = new int[m][n];
        for(int i = 0; i < m; i ++){
            Arrays.fill(cache[i], -1);
        }
        return uniquePathsHelperRecursionWithCache(row, col, m, n, cache);
    }

    private int uniquePathsHelperRecursionWithCache(int row, int col, int m, int n, int[][] cache) {
        if(row == m - 1 && col == n - 1){
            return 1;
        }
        if(row < 0 || row >=m || col < 0 || col >= n){
            return 0;
        }
        if(cache[row][col] != -1){
            return cache[row][col];
        }
        int sum = uniquePathsHelperRecursionWithCache(row+1, col, m, n, cache) +
                uniquePathsHelperRecursionWithCache(row, col+1, m, n, cache);
        return cache[row][col] = sum;
    }

    class Index {
        int m;
        int n;
        public Index(int m, int n){
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return m == index.m && n == index.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(m, n);
        }
    }
}
