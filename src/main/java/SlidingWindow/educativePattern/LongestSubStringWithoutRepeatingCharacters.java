package SlidingWindow.educativePattern;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args){
        System.out.println(LongestSubStringWithoutRepeatingCharacters.findLongestSubstring("abcdbea"));
    }

    public static int findLongestSubstring(String str) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int right = 0; right < str.length(); right ++){
            char currentChar = str.charAt(right);
            int index = indexMap.getOrDefault(currentChar, -1);
            if(index == -1 || index < left){
                indexMap.put(currentChar, right);
                maxLength = Math.max(maxLength, right - left + 1);
            }else{
                left = index+1;
                indexMap.put(currentChar, right);
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}
