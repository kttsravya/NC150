package LeetCode.AirBnb;

// later: check recursive dp problem from previous airbnb interview
// later: check graph problem from amazon interview

import java.util.HashMap;

public class MinimumWindowSubStringRevision {

    public static void main(String[] args){
        String s = "a";
        String t = "aa";
       String minString = minWindow(s, t);
       System.out.println(minString);
    }

    public static String minWindow(String s, String t){
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> sourceMap = new HashMap<>();
        String minWindowString = null;
        Integer minWindow = Integer.MAX_VALUE;
        for(int i = 0; i < t.length(); i++){
            int count = targetMap.getOrDefault(t.charAt(i), 0);
            count ++;
            targetMap.put(t.charAt(i), count);
            sourceMap.put(t.charAt(i), 0);
        }
        int numOfMatchingCharacters = targetMap.size();
        int currentMatchingCharacters = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right ++){
            char currentCharacter = s.charAt(right);

            if(sourceMap.containsKey(currentCharacter)){
                int count = sourceMap.get(currentCharacter);
                count++;
                sourceMap.put(currentCharacter, count);
                if(count == targetMap.get(currentCharacter)){
                    currentMatchingCharacters ++;
                }
            }

            // substring with all matching characters found
            if(currentMatchingCharacters == numOfMatchingCharacters){
               // shrink left window while window is valid
                while(numOfMatchingCharacters == currentMatchingCharacters && left <= right){
                    if(right - left + 1 < minWindow){
                        minWindow = right - left + 1;
                        minWindowString = s.substring(left, right + 1);
                    }
                    char c = s.charAt(left);
                    if(sourceMap.containsKey(c)){
                        int count = sourceMap.get(c);
                        if(count == targetMap.get(c)){
                            currentMatchingCharacters --;
                            count --;
                            sourceMap.put(c, count);
                        }else{
                            count --;
                            sourceMap.put(c, count);
                        }
                    }
                    left ++;
                }
            }
        }
        return minWindowString == null? "": minWindowString;
    }

}
