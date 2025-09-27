package LeetCode.WalmartLabs_3Months_EMH;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args){
        BestTimeToBuyAndSellStock2 buyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        int max = buyAndSellStock2.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(max);
    }

    public int maxProfit(int[] prices) {
        int[][] cache = new int[prices.length][2];
        for(int i = 0; i < cache.length; i ++){
            Arrays.fill(cache[i], -1);
        }
        return maxProfitHelper(prices, 0, 1, cache);
    }

    private int maxProfitHelper(int[] prices, int index, int isBuy, int[][] cache) {
        if (index == prices.length) {
            return 0;
        }

        if(cache[index][isBuy] != -1){
            return cache[index][isBuy];
        }

        int maxPrice = Integer.MIN_VALUE;

        if (isBuy == 1) {
            maxPrice = Math.max(maxProfitHelper(prices, index + 1, 0, cache) - prices[index],
                    maxProfitHelper(prices, index + 1, isBuy, cache));
        } else {
            maxPrice = Math.max(maxProfitHelper(prices, index + 1, 1, cache) + prices[index],
                    maxProfitHelper(prices, index + 1, 0, cache));
        }

        return cache[index][isBuy] = maxPrice;
    }

}
