package BitManipulation;

import org.junit.Assert;

public class CommonBitTasks {
    public static void main(String[] args){
        int num = 0b10; // binary value of 2 is 010
        CommonBitTasks commonBitTasks = new CommonBitTasks();

        boolean isOne =  commonBitTasks.getBit(num, 1);
        System.out.println(isOne);
        Assert.assertTrue(isOne);

        int setNumber =  commonBitTasks.setBit(num, 2);
        System.out.println(setNumber);
        Assert.assertEquals(6, setNumber);

        int clearNumber =  commonBitTasks.clearBit(num, 1);
        System.out.println(clearNumber);
        Assert.assertEquals(0, clearNumber);

        int clearAllBitsFromMostSignificantBitThroughI =  commonBitTasks.clearAllBitFromMostSignificantBitThroughIInclusive(16, 1);
        System.out.println(clearAllBitsFromMostSignificantBitThroughI);
        Assert.assertEquals(0, clearAllBitsFromMostSignificantBitThroughI);

        int clearAllBitsIThrough0 =  commonBitTasks.clearBitsIThrough0(16, 4);
        System.out.println(clearAllBitsIThrough0);
        Assert.assertEquals(0, clearAllBitsIThrough0);

        int updateBit =  commonBitTasks.updateBit(16, 4, false);
        System.out.println(updateBit);
        Assert.assertEquals(0, updateBit);

        int N = 0b10000000000;
        int M = 0b10011;
        int indexI = 2;
        int indexJ = 6;
        int insertedNumber = commonBitTasks.insert(N, M, indexI, indexJ);
        System.out.println(Integer.toBinaryString(insertedNumber));
    }

    /*public void toStringArray() {
        int[] nums = new int[]{1, 1, 0};
        String s = Arrays.toString(nums);

        int[] nums2 = new int[]{1, 1, 0};
        String t = Arrays.toString(nums2);

        System.out.println(s.equals(t));
    }*/

    public int insert(int bigNumber, int smallNumber, int positionI, int positionJ){
        // clear all bits from positionI through positionJ
        // create a mask with value zero between positionI through positionJ and with rest of the elements as 1. and do and(&) operation with bigNumber
        // step1: first deal with most significant bit through positionI
        // step1: second deal with from positionJ through least significant digit

        int mask = ~(-1 >>> (31- (positionJ)));
        System.out.println("creating mask" + Integer.toBinaryString(mask));

        int tempPosition = positionI - 1;
        while(tempPosition >= 0){
           boolean isBit = getBit(bigNumber, tempPosition);
           if(isBit){
               mask = setBit(mask, tempPosition);
           }
            tempPosition --;
        }
        System.out.println("modifiying mask" + Integer.toBinaryString(mask));

        smallNumber = smallNumber << positionI;
        System.out.println("shifting small number by positionI times " + Integer.toBinaryString(smallNumber));

        return (bigNumber & mask) | smallNumber;
    }

    // get the bit at ith position for the given number
    public boolean getBit(int num, int i){
        // Solution: shift one left by i times and perform & operation with num. check if the final value after and operation is 0.
        // If 0, bit at ith position is 0. otherwise, 1.
        boolean isNotZero = (num & (1<<i)) != 0;
        return isNotZero;
    }

    //set the bit at ith position for given number
    public int setBit(int num, int i){
      return num | (1 << i);
    }

    // clear bit
    public int clearBit(int num, int i){
        return num & ~(1 << i);
    }

    public int clearAllBitFromMostSignificantBitThroughIInclusive(int num, int i){
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public int clearBitsIThrough0(int num, int i){
        int mask = ~ (-1 >>> (31 - i));
        return num & mask;
    }

    public int updateBit(int num, int i, boolean bitIs1){
        int value = bitIs1 ? 1:0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);

    }
}
