package InterviewPrep_2025.LeetCode.BitManipulation;

public class SingleNumber {
    public static void main(String[] args){
        int[] input = {2,1,2,1};
        int ans = singleNumber(input);
        System.out.println(ans);
    }

    public static int singleNumber(int[] nums){
        int uniqueNumber = 0;
        for(int i = 0; i < nums.length; i ++){
            uniqueNumber = uniqueNumber ^ nums[i];
        }
        return uniqueNumber;
    }
}
