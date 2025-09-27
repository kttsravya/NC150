package InterviewPrep_2025.LeetCode.BitManipulation;

public class CountBits {
    public static void main(String[] args){
        int n = 9;
        int[] res = countBits(n);
        System.out.println(res[n]);
    }

    public static int[] countBits(int n){
        int[] p = new int[n + 1];
        p[0] = 0;
        int powerOf2 = 0;
        for(int i = 1; i <= n; i ++){
            if(i == (1 << (powerOf2 + 1))){
                powerOf2 = powerOf2 + 1;
            }
            p[i] = p[i - (1 << powerOf2)] + 1;
        }
        return p;
    }
}
