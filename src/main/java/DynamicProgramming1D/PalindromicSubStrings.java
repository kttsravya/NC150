package DynamicProgramming1D;

public class PalindromicSubStrings {
    public static void main(String[] args){
        PalindromicSubStrings palindromicSubStrings = new PalindromicSubStrings();
        int num = palindromicSubStrings.countSubstrings("abc");
        System.out.println(num);
    }

    public int countSubstrings(String s) {
        int totalSubStrings = 0;
        for(int i = 0; i < s.length(); i ++){
           // odd length palindrome
           totalSubStrings = totalSubStrings + countSubStringsHelper(i, i, s);
           // even length palindrome
           totalSubStrings = totalSubStrings + countSubStringsHelper(i, i+1, s);
        }
        return totalSubStrings;
    }
    private int countSubStringsHelper(int i, int j, String s){
        int left = i;
        int right = j;
        int numSubStrings = 0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            numSubStrings ++;
            left --;
            right ++;
        }
        return numSubStrings;
    }

}
