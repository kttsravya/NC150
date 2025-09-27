package DynamicProgramming1D;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        LongestPalindromicSubString palindromicSubString = new LongestPalindromicSubString();
        String longestPalindrome = palindromicSubString.longestPalindromeOptimizedByExpandingFromCenter("babad");
        System.out.println(longestPalindrome);
    }

    // O(n power 3)
    public String longestPalindrome(String s) {
        int nLengthSubString = s.length();
        while (nLengthSubString > 0) {
            for (int i = 0; i <= s.length() - nLengthSubString; i++) {
                String currentSubString = s.substring(i, i + nLengthSubString);
                System.out.println("currentSubString is "+ currentSubString);
                if (isAnagram(currentSubString)) {
                    return currentSubString;
                }
            }
            nLengthSubString--;
        }
        return "";
    }

    // O(n power 2)
    public String longestPalindromeOptimizedByExpandingFromCenter(String s) {
       int[] output = new int[]{0, 0};
       // odd palindromic cases
       for(int i = 0; i < s.length(); i ++){
           // odd palindromicLength
           int oddLength = expand(i, i, s);
           if(oddLength > output[1] - output[0] + 1){
               int distance = oddLength/2;
               output[0] = i - distance;
               output[1] = i + distance;
           }

           // even palindromicLength
           int evenLength = expand(i, i+1, s);
           if(evenLength > output[1] - output[0] + 1){
               int distance = (evenLength/2) - 1;
               output[0] = i - distance;
               output[1] = (i +1)+ distance;
           }
       }
        int i = output[0];
        int j = output[1];
        return s.substring(i, j+1);

    }

    private int expand(int i, int j, String s) {
        int left = i;
        int right = j;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right++;
        }
        return (right - left - 1);
    }

    private boolean isAnagram(String currentSubString) {
        int i = 0;
        int j = currentSubString.length() - 1;
        while (i <= j) {
            if (currentSubString.charAt(i) != currentSubString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
