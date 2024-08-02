package DynamicProgramming2D.MultipleStatesPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
// must watch : https://www.youtube.com/watch?v=IGIe46xw3YY&t=354s
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = {1, 3, 4, 0, 4};
        int maxProfit = bestTimeToBuyAndSellStockWithCooldown.maxProfit_Revision_BottomUp(prices);
        System.out.println("maxProfit is " + maxProfit);
    }

    public int maxProfit(int[] prices) {
        boolean isBuying = true;
        int index = 0;
        Map<CacheKey, Integer> maxProfitCache = new HashMap<>();
        return maxProfitHelper(prices, isBuying, index, maxProfitCache);
    }

    private int maxProfitHelper(int[] prices, boolean isBuying, int index, Map<CacheKey, Integer> maxProfitCache) {
        if (index >= prices.length) {
            return 0;
        }
        if (maxProfitCache.containsKey(new CacheKey(index, isBuying))) {
            return maxProfitCache.get(new CacheKey(index, isBuying));
        }
        int maxProfit = 0;
        if (isBuying) {
            int buy = maxProfitHelper(prices, !isBuying, index + 1, maxProfitCache) - prices[index];
            int cooldown = maxProfitHelper(prices, isBuying, index + 1, maxProfitCache);
            maxProfit = Math.max(buy, cooldown);
        } else {
            int sell = maxProfitHelper(prices, !isBuying, index + 2, maxProfitCache) + prices[index];
            int cooldown = maxProfitHelper(prices, isBuying, index + 1, maxProfitCache);
            maxProfit = Math.max(sell, cooldown);
        }
        maxProfitCache.put(new CacheKey(index, isBuying), maxProfit);
        return maxProfit;
    }

    public int maxProfit_Revision(int[] prices) {
        int buy = 1;
        int index = 0;
        int[][] cache = new int[2][prices.length];
        Arrays.fill(cache[0], -1);
        Arrays.fill(cache[1], -1);
        return maxProfitHelper_Revision(prices, buy, index, cache);
    }

    private int maxProfitHelper_Revision(int[] prices, int buy, int index, int[][] cache) {
        if(index >= prices.length){
            return 0;
        }
        if(cache[buy][index] != -1){
            return cache[buy][index];
        }
        int maxProfit = 0;
        if(buy == 1){
            maxProfit = Math.max(maxProfitHelper_Revision(prices, 0, index+1, cache) - prices[index],
                    maxProfitHelper_Revision(prices, 1, index+1, cache));
        }else{
            maxProfit = Math.max(maxProfitHelper_Revision(prices, 1, index+2, cache) + prices[index],
                    maxProfitHelper_Revision(prices, 0, index+1, cache));
        }
        return cache[buy][index] = maxProfit;
    }

    public int maxProfit_Revision_BottomUp(int[] prices) {
        int[][] dp = new int[2][prices.length+2];
        dp[0][prices.length] = dp[1][prices.length] =  0;
        dp[0][prices.length+1] = dp[1][prices.length+1] = 0;
        for(int i = prices.length - 1; i >= 0; i --){
            for(int buy = 0; buy <= 1; buy ++){
                if(buy == 0){
                     dp[buy][i] = Math.max(dp[1][i+2] + prices[i], dp[0][i+1]);
                }else{
                    dp[buy][i] = Math.max(dp[0][i+1] - prices[i], dp[1][i+1]);
                }
            }
        }
        return dp[1][0];
    }

    class CacheKey {
        int index;
        boolean isBuying;

        public CacheKey(int index, boolean isBuying) {
            this.index = index;
            this.isBuying = isBuying;
        }

        @Override
        public boolean equals(Object cacheKey) {
            if (this == cacheKey) return true;
            if (cacheKey == null || getClass() != cacheKey.getClass()) return false;
            CacheKey key = (CacheKey) cacheKey;
            return index == key.index && isBuying == key.isBuying;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, isBuying);
        }
    }
}
