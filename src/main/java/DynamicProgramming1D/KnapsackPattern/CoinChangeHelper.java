package DynamicProgramming1D.KnapsackPattern;


import java.util.Arrays;

public class CoinChangeHelper {
    int minCoins = Integer.MAX_VALUE;
    public static void main(String[] args){
        CoinChangeHelper coinChangeHelper = new CoinChangeHelper();
        int minNumOfCoinsRequired = coinChangeHelper.coinChange_BottomUp(new int[]{1,2,5}, 100);
        System.out.println("min coins" + minNumOfCoinsRequired);
    }



    /*public int coinChange(int[] coins, int amount) {
        return recursionHelper(coins, amount);
    }

    public int recursionHelper(int[] coins, int remain) {
       if(remain < 0){
           return -1;
       }
       if(remain == 0){
           return 0;
       }
       int minCount = Integer.MAX_VALUE;
       for(int coin : coins){
           int count = recursionHelper(coins, remain - coin);
           if(count == -1){
               continue;
           }
           minCount = Math.min(minCount, count + 1);
       }
       return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }*/

    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];
        Arrays.fill(cache, - 1);
        int min = coinChangeHelper(coins, amount, cache);
        System.out.println(min);
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    private int coinChangeHelper(int[] coins,  int amount,
                                 int[] cache) {
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        if(cache[amount] !=  -1){
            return cache[amount];
        }
        int minCoinsForGivenAmount = Integer.MAX_VALUE;
        // finding minCoins needed for given amount and updating the cache with optimized/min number of coins required to achieve amount.
        for(int i = 0; i < coins.length; i ++){
            int minCoins = coinChangeHelper(coins, amount - coins[i], cache);
            if(minCoins == -1){
                //System.out.println("Hit");
                continue;
            }
            minCoinsForGivenAmount = Math.min(minCoins, minCoinsForGivenAmount);
        }
        cache[amount] = (minCoinsForGivenAmount == Integer.MAX_VALUE) ? Integer.MAX_VALUE: 1 + minCoinsForGivenAmount;
        return cache[amount];
    }

    public int coinChange_BottomUp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 0; i <= amount; i ++){
            for(int j = 0; j < coins.length; j ++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == amount+1 ? -1: dp[amount];
    }
}

