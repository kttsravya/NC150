package LeetCode.WalmartLabs_3Months_EMH;

import java.util.HashSet;
import java.util.Set;

public class LengthOfTheLongestSubString {
    public static void main(String[] args){
        LengthOfTheLongestSubString length = new LengthOfTheLongestSubString();
        String s = "zxyzxyz";
        int maxLength = length.lengthOfLongestSubstring(s);
        System.out.println(maxLength);
    }

    public int lengthOfLongestSubstring(String s){
        int start = 0, end=0;
        Set<Character> distinctCharacters = new HashSet<>();
        int maxLength = Integer.MIN_VALUE;
        while(end < s.length()){
            while (distinctCharacters.contains(s.charAt(end))){
                distinctCharacters.remove(s.charAt(start));
                start++;
            }
            distinctCharacters.add(s.charAt(end));
            maxLength = Math.max(maxLength, (end-start+1));
            end++;
        }
        return maxLength;
    }
}
