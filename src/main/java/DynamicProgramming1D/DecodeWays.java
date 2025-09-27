package DynamicProgramming1D;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DecodeWays {
    int numOfWays = 0;
    HashSet<String> hashSet;
    public static void main(String[] args){
        DecodeWays decodeWays = new DecodeWays();
        String s = "10";
        int numOfWays = decodeWays.numDecodingsUsingCaching(s);
        System.out.println(numOfWays);
    }


    public int numDecodingsUsingCaching(String s) {
        hashSet = new HashSet<>();
        HashMap<Integer, Integer> cache = new HashMap<>();
        for(int i = 1; i <= 26; i ++){
            hashSet.add(String.valueOf(i));
        }
        int numOfDecodings = numDecodingsHelperUsingCaching(s, 0, cache);

        return numOfDecodings;
    }

    private int numDecodingsHelperUsingCaching(String s, int index, HashMap<Integer, Integer> cache) {
        if(cache.containsKey(index)){
            return cache.get(index);
        }
        // reached the end of the string, so return 1;
        if(index == s.length()){
            return 1;
        }
        int res = 0;
        if(index < s.length()){
            String oneCharacterSubString = s.substring(index, index+1);
            if(hashSet.contains(oneCharacterSubString)){
                res = numDecodingsHelperUsingCaching(s, index+1, cache);
            }
        }
        if(index + 1 < s.length()){
            String twoCharacterSubString = s.substring(index, index+2);
            if(hashSet.contains(twoCharacterSubString)){
                res = res + numDecodingsHelperUsingCaching(s, index+2, cache);
            }
        }
        cache.put(index, res);
        return res;
    }

    public int numDecodings(String s) {
        hashSet = new HashSet<>();
        for(int i = 1; i <= 26; i ++){
            hashSet.add(String.valueOf(i));
        }
        numDecodingsHelper(s, 0);

        return numOfWays;
    }

    private void numDecodingsHelper(String s, int index) {
        if(index == s.length()){
            numOfWays ++;
            return;
        }
        if(index < s.length()){
            String oneCharacterSubString = s.substring(index, index+1);
            if(hashSet.contains(oneCharacterSubString)){
                numDecodingsHelper(s, index+1);
            }
        }
        if(index + 1 < s.length()){
            String twoCharacterSubString = s.substring(index, index+2);
            if(hashSet.contains(twoCharacterSubString)){
                numDecodingsHelper(s, index+2);
            }
        }
    }


}
