package SlidingWindow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingSubStringWithReplacement {

    public static void main(String[] args){
        LongestRepeatingSubStringWithReplacement longest = new LongestRepeatingSubStringWithReplacement();
        int lon = longest.characterReplacement("AABABBA", 1);
        System.out.println(lon);

    }
    /*s="AABABBA"
            k=1*/
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int startPointer = 0;
        int endPointer = startPointer;
        int maxLength = 0;
        while (endPointer < s.length()){
            // adding element to map
            int frequency = frequencyMap.getOrDefault(s.charAt(endPointer), 0);
            frequency = frequency + 1;
            frequencyMap.put(s.charAt(endPointer), frequency);
            // get most frequent element from the map
            int frequentCount = findMostFrequentCharacter(frequencyMap);
            int windowSize = (endPointer - startPointer) + 1;

            if(frequentCount + k >= windowSize){
                maxLength = Math.max(windowSize, maxLength);
                endPointer ++;
            }else{
                System.out.println("****entered else case");
                while(frequentCount + k < windowSize){
                    // removing characters at start pointer from map
                    int count = frequencyMap.get(s.charAt(startPointer));
                    count = count - 1;
                    frequencyMap.put(s.charAt(startPointer), count);
                    frequentCount = findMostFrequentCharacter(frequencyMap);
                    windowSize = windowSize - 1;
                    startPointer ++;
                }
                endPointer ++;
            }
        }
        return maxLength;
    }

    private int findMostFrequentCharacter(Map<Character, Integer> frequencyMap) {
        int max = 0;
        Collection<Integer> values = frequencyMap.values();
        for(int value : values){
          if(value > max){
              max = value;
          }
          System.out.print("value is " +value + " ");
        }
        System.out.println();
       return max;
    }
}
