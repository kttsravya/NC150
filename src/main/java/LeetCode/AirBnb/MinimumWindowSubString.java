package LeetCode.AirBnb;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        String minSubString = minimumWindowSubString.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(minSubString);
    }

    public String minWindow(String source, String target) {
        int numOfMatchingCharacters = 0;
        int minWindow = Integer.MAX_VALUE;
        String minWindowString = null;
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        for (int i = 0; i < targetArray.length; i++) {
            int frequency = targetMap.getOrDefault(targetArray[i], 0);
            targetMap.put(targetArray[i], frequency + 1);
            windowMap.put(targetArray[i], 0);
        }
        int required = targetMap.size();
        int left = 0;
        for (int right = 0; right < source.length(); right++) {
            char c = source.charAt(right);
            if (target.indexOf(c) != -1) {
                windowMap.put(c, 1 + windowMap.getOrDefault(c, 0));
            }

            if (targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))) {
                numOfMatchingCharacters++;
            }

            while (numOfMatchingCharacters == required) {
                if ((right - left + 1) < minWindow) {
                    minWindow = (right - left + 1);
                    minWindowString = source.substring(left, right + 1);
                }
                char leftCharacter = source.charAt(left);
                if (target.indexOf(leftCharacter) != -1) {
                    windowMap.put(leftCharacter, windowMap.get(leftCharacter) - 1);
                }

                if (targetMap.containsKey(leftCharacter) && windowMap.get(leftCharacter) < targetMap.get(leftCharacter)) {
                    numOfMatchingCharacters--;
                }
                left = left + 1;
            }
        }
        return minWindow != Integer.MAX_VALUE ? minWindowString : "";
    }
}



