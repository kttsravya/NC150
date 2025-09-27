package InterviewPrep_2025.LeetCode.BitManipulation;

public class NumberOf1Bits {
    public static void main(String[] args){
        System.out.println(hammingWeight(2147483645));
    }

    public static int hammingWeight(int n){
        int i = 0;
        int hammingWeight = 0;
        while(i < 32){
            int lastBit = n & 1;
            if(lastBit == 1){
                hammingWeight ++;
            }
            n = n >> 1;
            i ++;
        }
        return hammingWeight;
    }

    public static int hammingWeightFlippingLeastSignificantDigit(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n & n-1);
        }
        return count;
    }
}
