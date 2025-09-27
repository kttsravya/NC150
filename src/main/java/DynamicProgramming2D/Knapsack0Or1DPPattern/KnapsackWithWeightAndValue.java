package DynamicProgramming2D.Knapsack0Or1DPPattern;
//https://leetcode.com/discuss/study-guide/1152328/01-Knapsack-Problem-and-Dynamic-Programming

public class KnapsackWithWeightAndValue {
    public static void main(String[] args){
        KnapsackWithWeightAndValue knapsack = new KnapsackWithWeightAndValue();
        int[] weights = {1, 2, 3};
        int[] value = {6, 10, 12};
        int W = 2;
        int maxPossibleValueWithinW = knapsack.findWWithMaximumValue_BottomUp(weights, value, W);
        System.out.println(maxPossibleValueWithinW);
    }

    public int findWWithMaximumValue(int[] weights, int[] value, int W){
       int[][] cache = new int[value.length+1][W+1];
        return findWWithMaximumValueHelper(weights, value, W, 0, cache);
    }

    public int findWWithMaximumValueHelper(int[] weights, int[] value, int W, int index, int[][] cache){
        if(W <= 0 || index == value.length){
            return 0;
        }

        int resultIncludingCurrentElement = 0;
        if(weights[index] <= W){
            resultIncludingCurrentElement = findWWithMaximumValueHelper(weights, value, W-weights[index], index+1, cache) + value[index];
        }
        int resultExcludingCurrentElement = findWWithMaximumValueHelper(weights, value, W, index+1, cache);
        return cache[index][W] = Math.max(resultIncludingCurrentElement, resultExcludingCurrentElement);
    }

    public int findWWithMaximumValue_BottomUp(int[] weights, int[] value, int W){
        int[][] dp = new int[value.length +1][W+1];
        for(int w = 0; w < W; w++){
            dp[dp.length - 1][w] = 0;
        }
        for(int index = 0; index < dp.length; index ++){
            dp[index][0] = 0;
        }
        for(int n = dp.length - 2; n >= 0; n -- ){
            for(int weight = 1; weight <= W; weight ++){
                if(weights[n] <= weight){
                    dp[n][weight] = Math.max(dp[n+1][weight - weights[n]]+value[n], dp[n+1][weight]);
                }else{
                    dp[n][weight] = dp[n+1][weight];
                }
            }
        }
        return dp[0][W];

    }

}
