package LeetCode.Paypal;

public class FindTheSmallestDivisorGivenTheThreshold {
    public static void main(String[] args){
        FindTheSmallestDivisorGivenTheThreshold smallestDivisor = new FindTheSmallestDivisorGivenTheThreshold();
        int smallestDiv = smallestDivisor.smallestDivisor(new int[]{200,100,14}, 10);
        System.out.println(smallestDiv);
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int smallestDivisor = Integer.MAX_VALUE;
        int low = 1;
        int high = getMax(nums);
        while(low <= high){
            int mid = (low + high)/2;
            System.out.println("low mid and high are "+ low + "," + mid +" ,"+ high);
            int sum = 0;
            for(int i = 0; i < nums.length; i ++){
                sum = sum + (int) Math.ceil((1.0* nums[i])/mid);
                if(sum > threshold){
                    break;
                }
            }
            if(sum > threshold){
                System.out.println("sum exceeds threshold: "+ sum);
                low = mid + 1;
            }else if(sum <= threshold){
                System.out.println("sum lower than threshold: "+ sum);
                smallestDivisor = Math.min(mid, smallestDivisor);
                high = mid - 1;
            }
        }
        return smallestDivisor == Integer.MAX_VALUE? -1 :smallestDivisor;
    }

    private int getMax(int[] nums) {
        Integer max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length; i ++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

}
