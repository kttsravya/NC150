package Greedy;

import java.util.Arrays;

public class CanCompleteCircuit {
    public static void main(String[] args){
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        int index = canCompleteCircuit.canCompleteCircuit_Greedy(new int[]{4}, new int[]{5});
        System.out.println(index);
    }

    public int canCompleteCircuit_Greedy(int[] gas, int[] cost){
        if(Arrays.stream(gas).sum() >= Arrays.stream(cost).sum()){
            int total = 0;
            int start = 0;
            for(int i = 0; i < gas.length; i ++){
                total = total + gas[i] - cost[i];
                if(total < 0){
                    total = 0;
                    start = i+1;
                }
            }
            return start;
        }
        return -1;
    }


    public int canCompleteCircuit_MemoryLimitExceeded(int[] gas, int[] cost) {
        int sumOfCosts = Arrays.stream(gas).sum();
        Boolean[][] cache = new Boolean[gas.length][sumOfCosts + 1];
         for(int i = 0; i < gas.length; i ++){
             if(canCompleteCircuitHelper(gas, cost, gas.length, i, 0, cache)){
                 return i;
             }
         }
         return -1;
    }

    private boolean canCompleteCircuitHelper(int[] gas, int[] cost, int nodesToTravel, int currentIndex, int remainingGas, Boolean [][] cache) {
        if(nodesToTravel == 0){
            return true;
        }
        currentIndex = (currentIndex) % gas.length;
        remainingGas = remainingGas + gas[currentIndex];
        if(cache[currentIndex][remainingGas] != null){
            return cache[currentIndex][remainingGas];
        }
        if(remainingGas < cost[currentIndex]){
            return false;
        }
        return cache[currentIndex][remainingGas] =  canCompleteCircuitHelper(gas, cost, nodesToTravel - 1,
                currentIndex+1, remainingGas - cost[currentIndex], cache);

    }

    public int canCompleteCircuit_TimeLimitExceeded(int[] gas, int[] cost) {
        int sumOfCosts = Arrays.stream(gas).sum();
        for(int i = 0; i < gas.length; i ++){
            if(canCompleteCircuitHelper(gas, cost, gas.length, i, 0)){
                return i;
            }
        }
        return -1;
    }

    private boolean canCompleteCircuitHelper(int[] gas, int[] cost, int nodesToTravel, int currentIndex, int remainingGas) {
        if(nodesToTravel == 0){
            return true;
        }
        currentIndex = (currentIndex) % gas.length;
        remainingGas = remainingGas + gas[currentIndex];
        if(remainingGas < cost[currentIndex]){
            return false;
        }
        return canCompleteCircuitHelper(gas, cost, nodesToTravel - 1,
                currentIndex+1, remainingGas - cost[currentIndex]);

    }


}
