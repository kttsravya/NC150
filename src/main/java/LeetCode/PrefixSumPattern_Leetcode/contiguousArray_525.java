package LeetCode.PrefixSumPattern_Leetcode;

//https://leetcode.com/problems/contiguous-array/editorial/

import java.util.HashMap;

public class contiguousArray_525 {
    public static void main(String[] args){
        contiguousArray_525 contiguousArray_525 = new contiguousArray_525();
        int max = contiguousArray_525.findMaxLength(new int[]{0,1,1});
        System.out.println(max);
    }

    public int findMaxLength(int[] nums) {
      HashMap<Integer, Integer> countAndFirstOccurence = new HashMap<>();
      // increment the variable if one is encountered, decrement the variable if zero is encountered
      int prefixSumUsingSingleVariable = 0;
      int maxLength = 0;
      countAndFirstOccurence.put(0, -1);

      for(int i = 0; i < nums.length; i ++){
          int currentValue = nums[i];
          if(currentValue == 1){
              prefixSumUsingSingleVariable = prefixSumUsingSingleVariable + 1;
          }else{
              prefixSumUsingSingleVariable = prefixSumUsingSingleVariable - 1;
          }
          System.out.println("prefix Sum is "+ prefixSumUsingSingleVariable);
         /* // meaning encountered equal numbers of 0's and 1's from begining of the array to current index
          if(prefixSumUsingSingleVariable == 0){
              maxLength = i+1;
          }*/
          // if same index appeared again, that means subarray between correspoinding previous index and current index has equal number of 0's and 1's
          if(! countAndFirstOccurence.containsKey(prefixSumUsingSingleVariable)){
              countAndFirstOccurence.put(prefixSumUsingSingleVariable, i);
          }else{
              maxLength = Math.max(maxLength, (i) - countAndFirstOccurence.get(prefixSumUsingSingleVariable));
          }
      }
      return maxLength;
    }
}
