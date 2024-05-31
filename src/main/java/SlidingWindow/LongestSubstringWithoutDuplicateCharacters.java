package SlidingWindow;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestSubstringWithoutDuplicateCharacters
{
    public int lengthOfLongestSubstring(String s) {
        int maxLengthOfLongestSubString = Integer.MIN_VALUE;
        int startPointer = 0;
        Set<Character> hashSet = new HashSet<>();
        if (s.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            // add method of hashset returns true when element got added to set (meaning, not a duplicate element)
            if (hashSet.add(s.charAt(i))) {
                maxLengthOfLongestSubString = Math.max(maxLengthOfLongestSubString, (i - startPointer) + 1);
            } else {
                while (s.charAt(startPointer) != s.charAt(i)) {
                    hashSet.remove(s.charAt(startPointer));
                    startPointer++;
                }
                startPointer++;
                hashSet.add(s.charAt(i));
                maxLengthOfLongestSubString = Math.max(maxLengthOfLongestSubString, (i - startPointer) + 1);
            }
        }
        return maxLengthOfLongestSubString;
    }

    private void printHashSet(Set<Character> hashSet) {
        Iterator<Character> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            Character c = iterator.next();
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args){
        String s = "thequickbrownfoxjumpsoverthelazydogthequickbrownfoxjumpsovert";
        int output = 17;
        LongestSubstringWithoutDuplicateCharacters longestSubstring = new LongestSubstringWithoutDuplicateCharacters();
        int lengthOfLongestSubString = longestSubstring.lengthOfLongestSubstring(s);
        Assert.assertEquals(output, lengthOfLongestSubString);
    }
}
