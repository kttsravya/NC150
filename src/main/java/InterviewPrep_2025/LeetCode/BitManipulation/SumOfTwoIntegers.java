package InterviewPrep_2025.LeetCode.BitManipulation;

public class SumOfTwoIntegers {
    public static void main(String[]  args){
        int a = 2;
        int b = 3;
        System.out.println(getSum(a, b));
    }
/*
 todo: works
 */

//    public static int getSum(int a, int b){
//        int result = 0;
//        int aLSB = 0;
//        int bLSB = 0;
//        int carry = 0;
//        StringBuilder sb = new StringBuilder();
//        while (a != 0 || b!= 0){
//            aLSB = a & 1;
//            bLSB = b & 1;
//            int digit = aLSB ^ bLSB ^ carry;
//            System.out.println("digit is " + digit);
//            sb.insert(0, digit);
//            carry = (aLSB & bLSB) | (carry & (aLSB ^ bLSB));
//            System.out.println("carry is " + carry);
//            a = a >>> 1;
//            b = b >>> 1;
//        }
//        if(carry != 0 && sb.length() < 32){
//            sb.insert(0, carry);
//        }
//        return Integer.parseUnsignedInt(sb.toString(), 2);
//    }

    /*
 todo: works
 */

//    public static int getSum(int a, int b){
//        int result = 0;
//        int aLSB = 0;
//        int bLSB = 0;
//        int carry = 0;
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < 32; i ++){
//            aLSB = a & 1;
//            bLSB = b & 1;
//            int digit = aLSB ^ bLSB ^ carry;
//            System.out.println("digit is " + digit);
//            sb.insert(0, digit);
//            carry = (aLSB & bLSB) | (carry & (aLSB ^ bLSB));
//            System.out.println("carry is " + carry);
//            a = a >>> 1;
//            b = b >>> 1;
//        }
//        return Integer.parseUnsignedInt(sb.toString(), 2);
//    }
    /*
 todo: works
 */

    public static int getSum(int a, int b){
        while (b != 0){
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
