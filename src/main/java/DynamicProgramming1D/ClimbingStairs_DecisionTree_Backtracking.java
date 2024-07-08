package DynamicProgramming1D;

import java.util.ArrayList;
import java.util.List;
// exponential time 2^h (height of the tree is n(target))
public class ClimbingStairs_DecisionTree_Backtracking {

    public static void main(String[] args){
        ClimbingStairs_DecisionTree_Backtracking stairs = new ClimbingStairs_DecisionTree_Backtracking();
        int numOfDistinctPaths = stairs.climbStairs_GetNumberOfWaysToReachN(19);
        System.out.println(numOfDistinctPaths);

    }

    public int climbStairs(int n){
       List<Integer> subset = new ArrayList<>();
       subset.add(1);
       subset.add(2);
        //subset.add(3);
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> currentPath = new ArrayList<>();
       int target = n;
       climbStairsHelper(subset, result, currentPath, target);
      /* for(int i = 0; i < result.size(); i ++){
           System.out.println(result.get(i).toString());
       }*/
       return result.size();
    }

    private void climbStairsHelper(List<Integer> subset, List<List<Integer>> result, List<Integer> currentPath, int target) {
        if(target == 0){
            result.add(currentPath);
            System.out.println(currentPath);
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = 0; i < subset.size(); i ++){
            int current = subset.get(i);
            currentPath.add(current);
            climbStairsHelper(subset, result, currentPath, target - current);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public int climbStairs_GetNumberOfWaysToReachN(int n){
        List<Integer> subset = new ArrayList<>();
        subset.add(1);
        subset.add(2);
        int target = n;
        int pathSum = 0;
        int numWays =  climbStairs_GetNumberOfWaysToReachNHelper(subset,pathSum, target);
        System.out.println(numWays);
        return numWays;
    }

    private int climbStairs_GetNumberOfWaysToReachNHelper(List<Integer> subset, int pathSum, int target) {
        System.out.println("path sum is "+ pathSum);
        if(target == pathSum){
            System.out.println("reached target");
            return 1;
        }
        if(pathSum > target){
            return 0 ;
        }
        int numOfWays = 0;
        for(int i = 0; i < subset.size(); i ++){
            int current = subset.get(i);
            pathSum = pathSum + current;
            numOfWays = numOfWays +  climbStairs_GetNumberOfWaysToReachNHelper(subset, pathSum, target);
            pathSum = pathSum - current;
        }
        return numOfWays;
    }
}
