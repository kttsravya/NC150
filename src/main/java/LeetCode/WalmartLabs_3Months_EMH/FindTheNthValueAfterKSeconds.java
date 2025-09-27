package LeetCode.WalmartLabs_3Months_EMH;

import java.util.Arrays;

public class FindTheNthValueAfterKSeconds {
    public static void main(String[] args){
        FindTheNthValueAfterKSeconds findTheNthValueAfterKSeconds = new FindTheNthValueAfterKSeconds();
        int nthValueAfterKSeconds = findTheNthValueAfterKSeconds.valueAfterKSeconds(4, 5);
        System.out.println(nthValueAfterKSeconds);
    }

    public int valueAfterKSeconds(int n, int k) {
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        int numOfSecondsPassed = 0;
        while(numOfSecondsPassed < k){
            for(int i = 1; i < temp.length; i ++){
                temp[i] = (temp[i - 1] + temp[i]) % (int)Math.pow(10,9);
            }
            numOfSecondsPassed++;
        }
        return temp[n - 1];
    }
}
