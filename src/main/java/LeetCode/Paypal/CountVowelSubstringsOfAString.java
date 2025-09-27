package LeetCode.Paypal;


import java.util.HashMap;
import java.util.HashSet;


public class CountVowelSubstringsOfAString {
    public static void main(String[] args){
        CountVowelSubstringsOfAString numOfVowelSubStrings = new CountVowelSubstringsOfAString();
        System.out.println(numOfVowelSubStrings.countVowelSubstrings("cuaieuouac"));
    }
    // Sliding window does not work for this one - word = "cuaieuouac"
    //"cuaieuouac" //- "cuaieuouac" //- "cuaieuouac" //- "cuaieuouac" //- "cuaieuouac"
    //- "cuaieuouac" //- "cuaieuouac"
    public int countVowelSubstrings_SlidingWIndow_WillNotWork(String word) {
        int numOfMatchingCharacters = 0;
        int numOfVowelSubStrings = 0;
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        Character[] vowel = new Character[]{'a','e','i','o','u'};
        for(Character c: vowel){
            vowelMap.put(c, 0);
        }
        int start = 0;
        for(int end = 0; end < word.length(); end ++){
            char currentCharacter = word.charAt(end);
            if(vowelMap.containsKey(currentCharacter)){
                vowelMap.put(currentCharacter, vowelMap.get(currentCharacter)+1);
                if(vowelMap.get(currentCharacter) == 1){
                    numOfMatchingCharacters ++;
                }
            }else{
                while(start <= end){
                    char currentStartCharacter = word.charAt(start);
                    if(vowelMap.containsKey(currentStartCharacter)){
                        vowelMap.put(currentStartCharacter, vowelMap.get(currentStartCharacter) - 1);
                        if(vowelMap.get(currentStartCharacter) == 0){
                            numOfMatchingCharacters --;
                        }
                        if(numOfMatchingCharacters == vowelMap.size()){
                            numOfVowelSubStrings++;
                        }
                    }
                    start ++;
                }
            }
            if(numOfMatchingCharacters == vowelMap.size()){
                numOfVowelSubStrings ++;
            }
        }
        return numOfVowelSubStrings;
    }

    // O(n pow 2) brute force solution (instead of O(n pow 3))
    public int countVowelSubstrings(String word) {
        int numOfVowelSubStrings = 0;
        for(int i = 0; i < word.length(); i ++){
            if(! isValid(word.charAt(i))){
                continue;
            }
            HashSet<Character>  hashSet = new HashSet<>();
            for(int j = i; j < word.length(); j ++){
                if(!isValid(word.charAt(j))){
                    break;
                }else{
                    hashSet.add(word.charAt(j));
                    if(hashSet.size() == 5){
                        numOfVowelSubStrings ++;
                    }
                }
            }
        }
        return numOfVowelSubStrings;
    }

    private boolean isValid(char character) {
        if(character == 'a' || character =='e' || character =='i' || character == 'o' || character == 'u'){
            return true;
        }
        return false;
    }
}
