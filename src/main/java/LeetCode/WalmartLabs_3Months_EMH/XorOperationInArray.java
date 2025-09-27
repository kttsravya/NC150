package LeetCode.WalmartLabs_3Months_EMH;

public class XorOperationInArray {
    public static void main(String[] args){

    }

    public int xorOperation(int n, int start) {
        int res = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = start + 2 * i;
            res = res ^ array[i];
        }
        return res;
    }
}
