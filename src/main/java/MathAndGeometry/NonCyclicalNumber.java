package MathAndGeometry;

import java.util.HashSet;

public class NonCyclicalNumber {
    public static void main(String[] args){
        NonCyclicalNumber nonCyclicalNumber = new NonCyclicalNumber();
        boolean isNonCyclical = nonCyclicalNumber.isHappy(101);
        System.out.println(isNonCyclical);
    }
    /*public boolean isHappy(int n) {
      HashSet<Integer> hasSum = new HashSet<>();
      int sum = 0;
      int prev = -1;
      while(! hasSum.contains(sum)){
          //reset sum to 0
          sum = 0;
          while (n > 0){
              sum = (int) (sum + Math.pow((double)(n % 10), (double)2));
              n = n/10;
          }
          System.out.println("sum is "+ sum);
          if(sum == 1){
              return true;
          }
          hasSum.add(prev);
          n = sum;
          prev = sum;
      }
      return false;
    }*/

    public boolean isHappy(int n) {
        HashSet<Integer> hasSum = new HashSet<>();
        int sum = 0;
        boolean isAbsent = true;
        while(isAbsent){
            //reset sum to 0
            sum = 0;
            while (n > 0){
                sum = (int) (sum + Math.pow((double)(n % 10), (double)2));
                n = n/10;
            }
            System.out.println("sum is "+ sum);
            if(sum == 1){
                return true;
            }
            isAbsent = hasSum.add(sum);
            n = sum;
        }
        return false;
    }
}
