package DynamicProgramming2D.StringSubSequencePattern;

import java.util.Arrays;
//https://leetcode.com/problems/interleaving-string/description/
public class InterleavingSubStrings {
    public static void main(String[] args){
        InterleavingSubStrings interleavingSubStrings = new InterleavingSubStrings();
        boolean isInterleaved = interleavingSubStrings.isInterleave("aabcc", "dbbca","aadbbcbcac");
        System.out.println(isInterleaved);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        Boolean[][] cache = new Boolean[s1.length()+1][s2.length()+1];
        boolean res =  isInterleaveHelper(s1, s2, s3, 0, 0, 0, cache);
        for(int i = 0; i < cache.length; i ++){
            System.out.println(Arrays.toString(cache[i]));
        }
        return res;
    }

    private boolean isInterleaveHelper(String s1, String s2, String s3, int index1,
                                       int index2, int index3, Boolean[][] cache){
        if(index1 == s1.length() && index2 == s2.length()){
            return true;
        }
        if(cache[index1][index2] != null){
            return cache[index1][index2];
        }
        boolean result = false;
        result = (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3) && isInterleaveHelper(s1, s2, s3, index1+1, index2, index3+1, cache))
           || (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3) && isInterleaveHelper(s1, s2, s3, index1, index2+1, index3+1, cache));

        cache[index1][index2] = result;
        return cache[index1][index2];
    }
}
