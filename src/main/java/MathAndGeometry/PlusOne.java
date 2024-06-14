package MathAndGeometry;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public static void main(String[] args){
        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne_CarryReminder(new int[]{9,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,9});
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
       BigInteger sum = BigInteger.ZERO;
       int mostSignificantMultiplier = digits.length - 1;
       int index = 0;
       while(mostSignificantMultiplier >= 0){
           BigInteger powerOfTen = BigInteger.TEN.pow(mostSignificantMultiplier);
           BigInteger currentDigit = powerOfTen.multiply(BigInteger.valueOf(digits[index]));
           //int currentDigit = (int)Math.pow(10, (double)mostSignificantMultiplier) * digits[index];
           sum =  sum.add(currentDigit);
           System.out.println("sum is "  + sum);
           mostSignificantMultiplier --;
           index ++;
       }
       sum = sum.add(BigInteger.ONE);
       System.out.println("sum is" + sum);
       List<Integer> result = new ArrayList<>();
       while(sum.compareTo(BigInteger.ZERO) > 0){
           int currentDigit = sum.mod(BigInteger.valueOf(10)).intValue();
           System.out.println("current digit"+ currentDigit);
           result.add(0, currentDigit);
           sum = sum.divide(BigInteger.valueOf(10));
           System.out.println("sum after division "+ sum);
       }
       int[] res = new int[result.size()];
       for(int i = 0; i < res.length; i ++){
           res[i] = result.get(i);
       }
       return res;
    }
    //1,2,3,4
    public int[] plusOne_CarryReminder(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int one = 1;
        int iterator = 0;
        // reverse the digits array (easy to proceed with the problem)
        for (int i = 0; i < digits.length; i++) {
            list.add(0, digits[i]);
        }
        while(iterator < list.size() && one != 0){
                if(list.get(iterator) == 9){
                    list.set(iterator, 0);
                }else{
                    list.set(iterator, list.get(iterator) + 1);
                    one = 0;
                }
            iterator ++;
        }
        if(one == 1) {
            list.add(one);
        }
        Collections.reverse(list);
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i ++){
            result[i] = list.get(i);
        }
        return result;
    }
}
