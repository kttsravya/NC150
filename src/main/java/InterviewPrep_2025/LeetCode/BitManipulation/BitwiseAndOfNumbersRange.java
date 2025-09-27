package InterviewPrep_2025.LeetCode.BitManipulation;

public class BitwiseAndOfNumbersRange {
    public static void main(String[] args){
        System.out.println(rangeBitWiseAnd(5,7));
    }

    public static int rangeBitWiseAnd(int left, int right){
        int shiftBits = 0;
        while(left != right){
            left >>>= 1;
            right >>>= 1;
            shiftBits ++;
        }
        while(shiftBits != 0){
            left <<= 1;
            shiftBits --;
        }
        return left;
    }
}
