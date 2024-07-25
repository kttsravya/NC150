package DynamicProgramming1D;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
// Leetcode Editorial video appraoch
public class WordBreak {
    public static void main(String[] args){
        WordBreak wordBreak = new WordBreak();
        List<String> dict = Arrays.asList("l", "le","lee","leet","code");
        boolean doesWordBreak = wordBreak.wordBreak_BottomUp("leetcode", dict);
        System.out.println(doesWordBreak);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String word: wordDict){
            dict.add(word);
        }
        int index = 0;
        int[] cache = new int[s.length()];
        Arrays.fill(cache,-1);
        boolean doesWordBreak = wordBreakHelper(index, dict, s, cache);
        System.out.println(Arrays.toString(cache));
        return doesWordBreak;
    }

    private boolean wordBreakHelper(int index,HashSet<String> dict, String s, int[] cache) {
        if(index == s.length()){
            return true;
        }
        // if previous path set this index to false, meaning word starting from index to end of string cannot be formed
        // using words in dictionary, hence returning.
        if(cache[index] == 0){
            return false;
        }
        int startIndex = index;
        for(int j = index + 1; j <= s.length() ; j ++ ){
            String subString = s.substring(startIndex, j);
            System.out.println(subString);
            if(dict.contains(subString)){
                if(wordBreakHelper(j, dict, s, cache)){
                    return true;
                }else{
                    // workbreak helper returned false, that means word can not be constructed using words from dict.
                    // hence starting from  j index to end of the string  set to false;
                    cache[j] = 0;
                }
            }
        }
        return false;
    }


    public boolean wordBreak_BottomUp(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i ++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
