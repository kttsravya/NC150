package DynamicProgramming2D;

public class LongestPalindromicSubString_BottomUp {
    public static void main(String[] args){
        LongestPalindromicSubString_BottomUp longestPalindromicSubString_bottomUp = new LongestPalindromicSubString_BottomUp();
        String longestString = longestPalindromicSubString_bottomUp.longestPalindrome("cbbd");
        System.out.println(longestString);
    }


    public String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] maxPalindromeLength = new int[]{0, 0};
        //Initialize all 1 character and 2 character palindromes to true
        for (int i = 0; i < dp.length; i++) {
            // one character
            dp[i][i] = true;
            if((i - i) > maxPalindromeLength[1] - maxPalindromeLength[0]){
                maxPalindromeLength[0] = i;
                maxPalindromeLength[1] = i;
            }


            // two character
            if (i - 1 >= 0 && input[i] == input[i - 1]) {
                dp[i - 1][i] = true;
                if((i - (i-1)) > maxPalindromeLength[1] - maxPalindromeLength[0]){
                    maxPalindromeLength[0] = i - 1;
                    maxPalindromeLength[1] = i;
                }

            }
        }
        System.out.println("maxPalindromicLength" + maxPalindromeLength[0] + " "+ maxPalindromeLength[1]);

        // populate for all odd sized strings
        int n = 3;
        while (n <= s.length()){
            for(int i = 0; i <= s.length() - n; i ++){
                int start = i;
                int end = i + (n - 1);
                if(input[start] == input[end] && dp[start+1][end - 1]){
                    dp[start][end] = true;
                    if((end - start) > (maxPalindromeLength[1] - maxPalindromeLength[0])){
                        maxPalindromeLength[0] = start;
                        maxPalindromeLength[1] = end;
                    }
                }
            }
            n =  n + 2;
        }

        // populate for all even sized strings
        n = 4;
        while (n <= s.length()){
            for(int i = 0; i <= s.length() - n; i ++){
                int start = i;
                int end = i + (n - 1);
                if(input[start] == input[end] && dp[start+1][end - 1]){
                    dp[start][end] = true;
                    if((end - start) > (maxPalindromeLength[1] - maxPalindromeLength[0])){
                        maxPalindromeLength[0] = start;
                        maxPalindromeLength[1] = end;
                    }
                }
            }
            n =  n + 2;
        }
        //printDP(dp);
        System.out.println(maxPalindromeLength[0] + " "+ maxPalindromeLength[1]);
        return s.substring(maxPalindromeLength[0], maxPalindromeLength[1]+1);
    }

    private void printDP(boolean[][] dp) {
        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < dp[i].length; j ++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }


}
