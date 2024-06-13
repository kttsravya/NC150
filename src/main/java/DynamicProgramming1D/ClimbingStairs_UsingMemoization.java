package DynamicProgramming1D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Memoization is a technique used in top-down recursive approach to avoid re computation. computation results are saved and will be reused later when conditions meet.]
// Time complexity is O(n)
public class ClimbingStairs_UsingMemoization {
    public static void main(String[] args) {
        ClimbingStairs_UsingMemoization c = new ClimbingStairs_UsingMemoization();
        int numWays = c.climbStairs_GetNumberOfWaysToReachNUsingMemoization(4);
        System.out.println(numWays);
    }

    public int climbStairs_GetNumberOfWaysToReachNUsingMemoization(int n) {
        List<Integer> subset = new ArrayList<>();
        subset.add(1);
        subset.add(2);
        int target = n;
        int pathSum = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        int numWays = climbStairs_GetNumberOfWaysToReachNUsingMemoizationHelper(subset, pathSum, target, memo);
        System.out.println(numWays);
        return numWays;
    }

    private int climbStairs_GetNumberOfWaysToReachNUsingMemoizationHelper(List<Integer> subset, int pathSum, int target, Map<Integer, Integer> memo) {
        if (target == pathSum) {
            return 1;
        }
        if (pathSum > target) {
            return 0;
        }
        int numOfWays = 0;
        if (memo.getOrDefault(pathSum, -1) != -1) {
            System.out.println("Using memoized results for pathSum " + pathSum);
            return memo.get(pathSum);
        }
        for (int i = 0; i < subset.size(); i++) {
            int current = subset.get(i);
            pathSum = pathSum + current;
            numOfWays = numOfWays + climbStairs_GetNumberOfWaysToReachNUsingMemoizationHelper(subset, pathSum, target, memo);
            pathSum = pathSum - current;
        }
        memo.put(pathSum, numOfWays);
        System.out.println("Inserting into memory for pathsum and numberofways to reach from pathsum to target " + pathSum + " " + numOfWays);
        return numOfWays;
    }
}
