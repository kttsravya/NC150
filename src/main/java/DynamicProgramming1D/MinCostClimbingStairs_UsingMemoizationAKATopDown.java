package DynamicProgramming1D;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs_UsingMemoizationAKATopDown {
    public static void main(String[] args) {
        MinCostClimbingStairs_UsingMemoizationAKATopDown climbingStairs = new MinCostClimbingStairs_UsingMemoizationAKATopDown();
        int minCost = climbingStairs.minCostClimbingStairs(new int[]{1, 2, 1, 2, 1, 1, 1});
        System.out.println(minCost);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] subSet = {1, 2};
        int targetIndex = cost.length;
        int pathCost = 0;
        Map<Integer, Integer> optimalCostCache = new HashMap<>();

        int minCostForIndex0 = minCostClimbingStairsHelperTemp(cost, subSet, 0, targetIndex, optimalCostCache);
        int minCostForIndex1 = minCostClimbingStairsHelperTemp(cost, subSet, 1, targetIndex, optimalCostCache);

        return Math.min(minCostForIndex0, minCostForIndex1);

    }

    private int minCostClimbingStairsHelper(int[] cost, int[] subSet, int currentIndex, int targetIndex,
                                            int pathCost, Map<Integer, Integer> optimalCostCache) {
        //System.out.println("currentIndex and pathCost to reach targetIndex " + currentIndex +" "+pathCost +" "+targetIndex);
        if (targetIndex == currentIndex) {
            //System.out.println("At target at index "+ currentIndex);
            return pathCost;
        }
        if (currentIndex > targetIndex) {
            return -1;
        }
        int minCost = Integer.MAX_VALUE;
        /*if (optimalCostCache.containsKey(currentIndex)) {
            System.out.println("Retrieving From Cache");
            return optimalCostCache.get(currentIndex);
        }*/
        for (int i = 0; i < subSet.length; i++) {
            int price = minCostClimbingStairsHelper(cost, subSet, currentIndex + subSet[i], targetIndex,
                    pathCost + cost[currentIndex], optimalCostCache);
            if (price != -1) {
                minCost = Math.min(price, minCost);
            }
        }
        System.out.println("MinPrice at Index i is " + minCost + " index is " + currentIndex);
        optimalCostCache.put(currentIndex, minCost);
        return minCost;
    }

    private int minCostClimbingStairsHelperTemp(int[] cost, int[] subSet, int currentIndex, int targetIndex,
                                                Map<Integer, Integer> optimalCostCache) {
        if (targetIndex == currentIndex) {
            return 0;
        }
        if (targetIndex < currentIndex) {
            return -1;
        }
        int minCost = Integer.MAX_VALUE;
        if (optimalCostCache.containsKey(currentIndex)) {
            System.out.println("Retrieving From Cache");
            return optimalCostCache.get(currentIndex);
        }
        for (int i = 0; i < subSet.length; i++) {
            int optimalPriceForGivenIndex = minCostClimbingStairsHelperTemp(cost, subSet, currentIndex + subSet[i], targetIndex,
                    optimalCostCache);
            int priceOption = 0;
            if (optimalPriceForGivenIndex != -1) {
                priceOption = cost[currentIndex] + optimalPriceForGivenIndex;
                minCost = Math.min(priceOption, minCost);
            }
            System.out.println("price at current index" + (currentIndex + subSet[i]) + " is " + optimalPriceForGivenIndex);
        }
        System.out.println("MinPrice at Index i is " + minCost + " index is " + currentIndex);
        optimalCostCache.put(currentIndex, minCost);
        return minCost;
    }
}
