package DynamicProgramming2D;

public class PalindromicSubStrings_BottomUP {
    public static void main(String[] args){
        PalindromicSubStrings_BottomUP palindromicSubString = new PalindromicSubStrings_BottomUP();
        int palindromicSubStrings = palindromicSubString.longestPalindrome("abc");
        System.out.println(palindromicSubStrings);
    }
    public int longestPalindrome(String s) {
        char[] input = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxPalindromeLength = 0;
        //Initialize all 1 character and 2 character palindromes to true
        for (int i = 0; i < dp.length; i++) {
            // one character
            dp[i][i] = true;

            // two character
            if (i - 1 >= 0 && input[i] == input[i - 1]) {
                dp[i - 1][i] = true;
            }
        }

        // populate for all odd sized strings
        int n = 3;
        while (n <= s.length()){
            for(int i = 0; i <= s.length() - n; i ++){
                int start = i;
                int end = i + (n - 1);
                if(input[start] == input[end] && dp[start+1][end - 1]){
                    dp[start][end] = true;
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
                }
            }
            n =  n + 2;
        }

        // count all true and return count
        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < dp[i].length; j ++){
                if(dp[i][j]){
                    maxPalindromeLength ++;
                }
            }
        }
        return maxPalindromeLength;
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
