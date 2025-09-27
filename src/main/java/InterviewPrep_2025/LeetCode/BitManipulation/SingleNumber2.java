package InterviewPrep_2025.LeetCode.BitManipulation;

public class SingleNumber2 {
    public static void main(String[] args){
       int output =  singleNumber((new int[]{0,1,0,1,0,1,99}));
       System.out.println(output);
    }

    public static int singleNumber(int[] nums){
        int loner = 0;
        for(int i = 0; i < 32; i ++){
            int bitSum = 0;
            int lonerbit = 0;
            for(int j = 0; j < nums.length; j ++){
                 bitSum = ((nums[j] >>> i) & 1 ) + bitSum;
            }
             lonerbit = bitSum % 3;
             loner = loner | (lonerbit <<i);
        }
        return loner;
    }
}
