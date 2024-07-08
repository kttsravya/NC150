package DynamicProgramming2D;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = {1, 3, 4, 0, 4};
        int maxProfit = bestTimeToBuyAndSellStockWithCooldown.maxProfit(prices);
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
