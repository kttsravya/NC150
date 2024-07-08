package DynamicProgramming1D;

public class ClimbingStairs_BottomsUpApproach_DP {
    public static void main(String[] args){
        ClimbingStairs_BottomsUpApproach_DP climbingStairs = new ClimbingStairs_BottomsUpApproach_DP();
        int numWays = climbingStairs.climbStairs(4);
        System.out.println(numWays);
    }

    public int climbStairs(int n) {
      int numWaysFromLastStep = 0;
      int numWaysFromLastMinusOneStep = 1;
      int temp = 0;
      for(int i = 0; i < n; i ++){
          temp = numWaysFromLastMinusOneStep + numWaysFromLastStep;
          numWaysFromLastStep = numWaysFromLastMinusOneStep;
          numWaysFromLastMinusOneStep = temp;
      }
      return temp;
    }
}
