package InterviewPrep_2025.LeetCode.BitManipulation;

public class ReverseBits {
    public static void main(String[] args){
        int n = 43261596;
        System.out.println(reverseBits(n));
    }
    public static int reverseBits( int n){
        int reversedValue = 0;
        int position = 31;
        while(n != 0){
            int leastSignificatnBit = n & 1;
            System.out.println("LSB is "+ leastSignificatnBit);
            n = n >>> 1;
            reversedValue = reversedValue + (leastSignificatnBit << position);
            position = position - 1;
        }
        return reversedValue;
    }
}
