package InterviewPrep_2025.LeetCode.BitManipulation;

import java.math.BigInteger;

// Given a 32-bit integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

public class NumberToHexadecimal {
    public static void main(String[] args) {
        // String answer =  toHex(-2147483648);
        System.out.println(trialAndError(20));
        // System.out.println(answer);
    }

    public static String toHex(int num) {
        boolean isPositive = num >= 0;
        StringBuilder hexaDecimal = new StringBuilder();
        BigInteger numInTwosCompliment = new BigInteger(String.valueOf(num));
        if (num == 0) {
            return "0";
        }
        if (!isPositive) {
            numInTwosCompliment = new BigInteger(String.valueOf((long) Math.pow(2.0, 32.0) + num));
            System.out.println("value in two's compliment is " + numInTwosCompliment.longValue());
        }
        char[] decimalToHexMapping = {'a', 'b', 'c', 'd', 'e', 'f'};
        while (numInTwosCompliment.longValue() / 16 > 0) {
            long remainder = numInTwosCompliment.longValue() % 16;
            if (remainder > 9) {
                remainder = remainder - 10;
                hexaDecimal.append(decimalToHexMapping[(int) remainder]);
            } else {
                hexaDecimal.append(remainder);
            }
            numInTwosCompliment = new BigInteger(String.valueOf(numInTwosCompliment.longValue() / 16));
        }
        if (numInTwosCompliment.longValue() > 9) {
            numInTwosCompliment = new BigInteger(String.valueOf(numInTwosCompliment.longValue() - 10));
            hexaDecimal = hexaDecimal.append(decimalToHexMapping[numInTwosCompliment.intValue()]);
        } else {
            hexaDecimal = hexaDecimal.append(numInTwosCompliment.intValue());
        }
        return hexaDecimal.reverse().toString();
    }

    //alternative snippet, not complete code
    public static String trialAndError(int num) {
        if (num == 0) return "0";

        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        boolean started = false; // have we seen the first non-zero nibble?
        for (int i = 7; i >= 0; i--) {
            int nibble = (num >>> (4 * i)) & 0xF; // unsigned shift, then mask to 4 bits
            if (!started) {
                if (nibble == 0) continue; // skip leading zeros
                started = true;
            }
            sb.append(map[nibble]);
        }
        return sb.toString();
    }
}
