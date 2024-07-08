package BitManipulation;

public class NumberOfOneBits {
    public static void main(String[] args) {
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        int hammingWeight = 0b11111111111111111111111111111101;
        int numOfOnes = numberOfOneBits.hammingWeight(hammingWeight);
        System.out.println(numOfOnes);
    }

    public int hammingWeight(int n) {
        System.out.println("received value is " + n);
        int countOfOnes = 0;
        while (n > 0) {
            int res = n % 2;
            if (res == 1) {
                countOfOnes++;
            }
            n = n >> 1;
        }
        return countOfOnes;    }
}
