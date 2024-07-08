package DynamicProgramming1D;



public class MinCostClimbingStairs_BottomUp_PureDP {
    public static void main(String[] args){
        MinCostClimbingStairs_BottomUp_PureDP minCostDP = new MinCostClimbingStairs_BottomUp_PureDP();
        int minCost = minCostDP.minCostClimbingStairs(new int[]{1,2,1,2,1,1,1});
        System.out.println(minCost);
    }

    public int minCostClimbingStairs(int[] cost) {
       int costAtLastStep = cost[cost.length - 1];
       int costAtLastStepMinusOne = cost[cost.length - 2];
       int currentStepCost = 0;
       int currentIndex = cost.length - 2;
       int numOfIterations = cost.length - 2;

       if(cost.length == 2){
           return costAtLastStepMinusOne;
       }
       if(cost.length == 1){
           return costAtLastStep;
       }
       while(numOfIterations > 0){
            currentStepCost = cost[currentIndex - 1] + Math.min(costAtLastStep, costAtLastStepMinusOne);
            System.out.println ("cost at current step "+ currentStepCost + " ");
            costAtLastStep = costAtLastStepMinusOne;
            costAtLastStepMinusOne = currentStepCost;
            numOfIterations --;
            currentIndex --;
       }
       return Math.min(costAtLastStepMinusOne, costAtLastStep);
    }

}
