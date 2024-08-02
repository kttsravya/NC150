package DynamicProgramming2D.UnboundedKnapsack0Or1DPPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange2 {
    public static void main(String[] args){
        CoinChange2 coinChange2 = new CoinChange2();
        int numOfWays = coinChange2.change_BottomUp(4, new int[]{1, 2, 3});
        System.out.println(numOfWays);
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] cache = new int[amount+1][coins.length];
        for(int i = 0; i < cache.length; i ++){
            Arrays.fill(cache[i], -1);
        }
        List<Integer> currentPath = new ArrayList<>();
        int numOfWays =  coinChangeHelper(amount, coins, coins.length-1, cache, currentPath);
        for(int i = 0; i < cache.length; i ++){
            System.out.println(Arrays.toString(cache[i]));
        }
        return numOfWays;
    }

    private int coinChangeHelper(int target, int[] coins, int index, int[][] cache, List<Integer> currentPath) {
        if(target == 0){
            System.out.println(currentPath.toString());
            System.out.println("reached");
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(cache[target][index] != -1){
            return cache[target][index];
        }
        int numOfWays = 0;
        for(int i = index; i >= 0; i --){
            currentPath.add(coins[i]);
            int res = coinChangeHelper(target - coins[i], coins,i, cache, currentPath);
            currentPath.remove(currentPath.size() - 1);
            if(res > 0){
                numOfWays = numOfWays + res;
            }
        }
        return cache[target][index] = numOfWays;
    }


    public int change_Revision(int amount, int[] coins) {
        int[][] cache = new int[amount+1][coins.length];
        for(int i = 0; i < cache.length; i ++){
            Arrays.fill(cache[i], -1);
        }
        int numOfWays =  coinChangeHelper_Revision(amount, coins, 0, cache);
        for(int i = 0; i < cache.length; i ++){
            System.out.println(Arrays.toString(cache[i]));
        }
        return numOfWays;
    }

    private int coinChangeHelper_Revision(int target, int[] coins, int index, int[][] cache) {
        if(target == 0){
            return 1;
        }
        if(target < 0 || index >= coins.length){
            return 0;
        }
        if(cache[target][index] != -1){
            return cache[target][index];
        }
        int numWays =  coinChangeHelper_Revision(target-coins[index], coins, index, cache) +
                coinChangeHelper_Revision(target, coins, index+1, cache);
        return cache[target][index] = numWays;
    }

    public int change_BottomUp(int amount, int[] coins) {
        int n = coins.length;
        //System.out.println(n);
        int[][] dp = new int[n+1][amount+1];
        //System.out.println(dp.length);
        for(int i = 0; i < n; i ++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= amount; i ++){
            dp[n][i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[0][amount];
    }
}
