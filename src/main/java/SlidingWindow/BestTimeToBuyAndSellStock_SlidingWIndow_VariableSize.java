package SlidingWindow;

public class BestTimeToBuyAndSellStock_SlidingWIndow_VariableSize {
    // Sliding window variable size
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices.length < 2){
            return maxProfit;
        }
        int leftPointer = 0;
        int rightPointer = leftPointer + 1;
        while(rightPointer < prices.length){
            if(prices[leftPointer] < prices[rightPointer]){
                maxProfit = Math.max(maxProfit, prices[rightPointer] - prices[leftPointer]);
            }else{
                leftPointer = rightPointer;
            }
            rightPointer ++;
        }
        return maxProfit;
    }

    public int maxProfit_SingleTransaction(int[] prices){
        int maxProfit = Integer.MIN_VALUE;
        int minSoFar = prices[0];
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] >= minSoFar){
                maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            }
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return maxProfit > 0? maxProfit: 0;
    }

    public static void main(String[] args){
        int[] prices = {10,1,5,6,7,1};
        BestTimeToBuyAndSellStock_SlidingWIndow_VariableSize bt = new BestTimeToBuyAndSellStock_SlidingWIndow_VariableSize();
        int maxProfit = bt.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
