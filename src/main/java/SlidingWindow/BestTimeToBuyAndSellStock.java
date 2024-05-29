package SlidingWindow;

public class BestTimeToBuyAndSellStock {

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

    public static void main(String[] args){
        int[] prices = {10,1,5,6,7,1};
        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock();
        int maxProfit = bt.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
