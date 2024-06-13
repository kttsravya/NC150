package DynamicProgramming2D;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountPaths_TopDownAKAMemoization_DP {
    public static void main(String[] args){
        CountPaths_TopDownAKAMemoization_DP countPaths = new CountPaths_TopDownAKAMemoization_DP();
        int uniqueNumOfWays = countPaths.uniquePaths(25, 25);
        System.out.println(uniqueNumOfWays);
    }

    public int uniquePaths(int m, int n) {
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
