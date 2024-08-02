package DynamicProgramming2D.MultipleStatesPattern;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args){
        BestTimeToBuyAndSellStock2 buyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        int result = buyAndSellStock2.maxProfit_BottomUp(new int[]{7,1,5,3,6,4});
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int[][] cache = new int[2][prices.length];
        Arrays.fill(cache[0], -1);
        Arrays.fill(cache[1], -1);
        int maxProfit = maxProfitHelper(prices, 0, cache, 1);
        return maxProfit;
    }

    public int maxProfitHelper(int[] prices, int index, int[][] cache, int buy){
        if(prices.length == index){
            return 0;
        }
        if(cache[buy][index] != -1){
            return cache[buy][index];
        }
        int tempProfit = 0;
        if(buy == 1){
            tempProfit = Math.max(maxProfitHelper(prices, index+1, cache, 0) - prices[index],
                    maxProfitHelper(prices, index+1, cache, 1));
        }else{
            tempProfit = Math.max(maxProfitHelper(prices, index+1, cache, 1) + prices[index],
                    maxProfitHelper(prices, index+1, cache, 0));
        }
        cache[buy][index]= tempProfit;
        return tempProfit;
    }

    public int maxProfit_BottomUp(int[] prices) {
        int[][] cache = new int[2][prices.length+1];
        cache[0][prices.length] = 0;
        cache[1][prices.length] = 0;
        for(int i = prices.length - 1; i >=0; i--){
            for(int buy=0; buy <=1; buy++){
                if(buy == 0){
                    cache[buy][i] = Math.max(cache[1][i+1] + prices[i], cache[0][i+1]);
                }else{
                    cache[buy][i] = Math.max(cache[0][i+1] - prices[i], cache[1][i+1]);
                }
            }
        }
        return cache[1][0];
    }
}
