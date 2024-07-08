package ArraysAndHashing;

import java.util.Arrays;
public class ProductsOfArrayDiscludingSelf {
    public static void main(String[] args){
        ProductsOfArrayDiscludingSelf products = new ProductsOfArrayDiscludingSelf();
        int[] nums = {1,2,4,6};
        int[] res = products.productExceptSelfOptimized(nums);
        System.out.println(Arrays.toString(res));
    }
    public int[] productExceptSelf(int[] nums) {
       System.out.println("Input"+ Arrays.toString(nums));
       int[] left = new int[nums.length];
       int[] right = new int[nums.length];
       left[0] = nums[0];
       for(int i = 1; i < left.length; i ++){
           left[i] = left[i - 1]* nums[i];
       }
       System.out.println("Left" +Arrays.toString(left));
       right[right.length - 1] = nums[nums.length - 1];
       for(int j = right.length - 2; j >=0; j--){
           right[j] = right[j + 1] * nums[j];
       }
       System.out.println("Right"+ Arrays.toString(right));
       for(int i = 0; i < nums.length; i ++){
           int leftProductExcludingItself = 1;
           int righProductExcludingItself = 1;
           if(i - 1 >= 0){
               leftProductExcludingItself = left[i - 1];
           }
           if(i + 1 < nums.length){
               righProductExcludingItself = right[i + 1];
           }
           nums[i] = leftProductExcludingItself *righProductExcludingItself;
       }
       return nums;
    }

    public int[] productExceptSelfOptimized(int[] nums) {
        System.out.println("Input"+ Arrays.toString(nums));
        int[] output = new int[nums.length];
        int prefix = 1;
        int postfix = 1;
        for(int i = 0; i < output.length; i ++){
                output[i] = prefix;
                prefix = prefix * nums[i];
        }
        for(int j = output.length - 1; j >=0; j --){
             output[j] = output[j]* postfix;
             postfix = postfix * nums[j];
        }
        return output;
    }
}
