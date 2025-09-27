package SlidingWindow.educativePattern;

import java.util.HashMap;

public class MinimumWindowSubString {
    public static void main(String[] args){
        String result = MinimumWindowSubString.minWindow("y", "k");
        System.out.println(result);
    }

    public static String minWindow(String s, String t){
        HashMap<Character,Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        if(t.isBlank() || t.length() > s.length()){
            return "";
        }

        for(int i = 0; i < t.length(); i ++){
            char c =  t.charAt(i);
            int freq = targetMap.getOrDefault(c, 0);
            targetMap.put(c, freq + 1);
        }
        int targetCount = targetMap.size();
        int currentCount = 0;
        int left = 0;
        int minWindow = Integer.MAX_VALUE;
        String minWindowString = "";

        System.out.println("targetCount is "+ targetCount);

        for(int right = 0; right < s.length(); right ++){
            char c = s.charAt(right);
            if(targetMap.containsKey(c)) {
                int freq = windowMap.getOrDefault(c, 0);
                freq = freq + 1;
                windowMap.put(c, freq);
            }
            if(targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))){
               currentCount = currentCount + 1;
            }

            while(targetCount == currentCount){
                char leftChar = s.charAt(left);
                if((right - left + 1) <  minWindow){
                    minWindow = right - left + 1;
                    minWindowString = s.substring(left, right+1);
                    System.out.println("left and right is "+ left + " "+right + " "+ minWindowString);
                }
                if(targetMap.containsKey(leftChar)) {
                    int currentFreq = windowMap.get(leftChar) - 1;
                    windowMap.put(leftChar, currentFreq);
                }
                if(windowMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)){
                   currentCount --;
                }
                left ++;
            }

        }
        return minWindowString;
    }
}
