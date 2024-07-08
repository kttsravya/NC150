package BitManipulation;

public class SingleNumber {
    public static void main(String[] args){
     SingleNumber singleNumber = new SingleNumber();
     int uniqueNumber = singleNumber.singleNumber(new int[]{3, 2, 3});
     System.out.println(uniqueNumber);
    }

    public int singleNumber(int[] nums) {
        int startElement = nums[0];
        for(int i = 1; i < nums.length; i ++){
           startElement = startElement ^ nums[i];
        }
        return startElement;
    }
}
