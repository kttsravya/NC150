package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationString {
    public static void main(String[] args){
        PermutationString permutationString = new PermutationString();
        boolean checkInc =  permutationString.permutationStringSlidingWindowUsingMatches("abc", "lecabee");
        System.out.println("checkInc"+ checkInc);

    }

    public boolean permutationStringSlidingWindowUsingMatches(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        // create a dict of s1
       HashMap<Integer, Integer> s1Map = new HashMap<>();
       HashMap<Integer, Integer> s2Map = new HashMap<>();
       for(int i = 0; i < s1.length(); i ++){
           s1Map.put((int)s1.charAt(i), s1Map.getOrDefault((int)s1.charAt(i), 0) + 1);
           s2Map.put((int)s2.charAt(i), s2Map.getOrDefault((int)s2.charAt(i), 0) + 1);
       }
        int matches = 0;
        for(int alphabet = 0; alphabet < 26; alphabet ++){
            int key = 'a'+ alphabet;
            int s1MapValue = s1Map.getOrDefault(key,0);
            int s2MapValue = s2Map.getOrDefault(key, 0);
            System.out.println("s1 and s2 map values are "+ s1MapValue +" "+ s2MapValue);
            if(s1Map.getOrDefault(key,0).equals(s2Map.getOrDefault(key, 0))){
                matches ++;
            }
            System.out.println("key and matches are "+ key +" "+ matches);
        }
        int startPointer = 0;
        for(int i = s1.length(); i < s2.length(); i ++){
            if(matches == 26){
                return true;
            }
            char addedCharacterToWindow = s2.charAt(i);
            char removingCharacterFromWindow = s2.charAt(startPointer);
            s2Map.put((int)addedCharacterToWindow, s2Map.getOrDefault((int)addedCharacterToWindow, 0) + 1);
            // making changes to matches count as per recently added character to window
            if(s2Map.getOrDefault((int)addedCharacterToWindow, 0).equals(s1Map.getOrDefault((int)addedCharacterToWindow, 0))){
                matches ++;
            // else if: modifying previously matched character(creating a mismatch),hence reducing the count by 1.
            }else if ((s1Map.getOrDefault((int)addedCharacterToWindow, 0)+ 1) == (s2Map.get((int)addedCharacterToWindow))){
                matches --;
            }
            s2Map.put((int)removingCharacterFromWindow, s2Map.getOrDefault((int)removingCharacterFromWindow, 0) -1);
            // making changes to matches count as per recently removed character from window
            if(s2Map.getOrDefault((int)removingCharacterFromWindow, 0).equals(s1Map.getOrDefault((int)removingCharacterFromWindow, 0))){
                matches ++;
                // else if: modifying previously matched character(creating a mismatch),hence reducing the count by 1.
            }else if ((s1Map.getOrDefault((int)addedCharacterToWindow, 0)- 1) == (s2Map.get((int)addedCharacterToWindow))){
                matches --;
            }
            startPointer ++;
        }
        return matches == 26;
    }

    public boolean checkInclusionSlidingWindow(String s1, String s2) {
        // create a dict of s1
        int[] dict = new int[26];
        int[] dict2 = new int[26];
        for(int i = 0; i < s1.length(); i ++){
            dict[s1.charAt(i) - 'a'] ++;
            dict2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2.length()-s1.length(); i ++){
            if(matches(dict, dict2)){
                return true;
            }
            dict2[s2.charAt(i + s1.length()) - 'a'] ++;
            dict2[s2.charAt(i) - 'a']--;
        }
        return matches(dict, dict2);
    }

    private boolean matches(int[] dict, int[] dict2) {
        for(int i = 0; i< dict.length; i ++){
            if(dict[i] != dict2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        // create a dict of s1
        int[] dict = new int[26];
        for(int i = 0; i < s1.length(); i ++){
            dict[s1.charAt(i) - 'a'] = dict[s1.charAt(i) - 'a'] + 1;
        }
        System.out.println(Arrays.toString(dict));
        int startPointer = 0;
        int endPointer = 0;

        while(startPointer < s2.length()){
            if(dict[s2.charAt(startPointer) - 'a'] == 0){
                startPointer ++;
                endPointer ++;
                continue;
            } else{
                int boundary = startPointer + s1.length() - 1;
                System.out.println("boundary is "+ boundary);
                if(boundary >= s2.length()){
                    return false;
                }
                int[] tempDict = Arrays.copyOfRange(dict, 0, dict.length);
                System.out.println(Arrays.toString(tempDict));

                while(endPointer <= boundary){
                    if(tempDict[s2.charAt(endPointer) - 'a'] > 0){
                        tempDict[s2.charAt(endPointer) - 'a'] = tempDict[s2.charAt(endPointer)- 'a'] - 1;
                        endPointer ++;
                    }else{
                        break;
                    }
                }
                if(endPointer == boundary + 1){
                    return  true;
                }
                startPointer = startPointer + 1;
                endPointer = startPointer;
            }
        }
        return false;
    }
}
