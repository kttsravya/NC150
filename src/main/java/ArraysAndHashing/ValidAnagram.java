package ArraysAndHashing;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagramUsingArrays(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] sCharacterArray = s.toCharArray();
        char[] tCharacterArray = t.toCharArray();
        int[] characterCount = new int[26];
        for (int i = 0; i < characterCount.length; i++) {
            characterCount[i] = 0;
        }

        for (int i = 0; i < sCharacterArray.length; i++) {
            int characterIntegerValue = sCharacterArray[i];
            //System.out.println(characterIntegerValue);
            int index = sCharacterArray[i] - 97;
            //System.out.println(index);
            characterCount[index] = characterCount[index] + 1;
        }

        for (int i = 0; i < tCharacterArray.length; i++) {
            int characterCountIndex = tCharacterArray[i] - 97;
            if (characterCount[characterCountIndex] <= 0) {
                return false;
            } else {
                characterCount[characterCountIndex] = characterCount[characterCountIndex] - 1;
            }
        }
        return true;
    }

    public boolean isAnagramUsingHashMap(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> hashMapSource = new HashMap<>();
        HashMap<Character, Integer> hashMapTarget = new HashMap<>();

        for(int i = 0; i < s.length(); i ++){
            char sourceStringCharacter = s.charAt(i);
            int count = hashMapSource.getOrDefault(sourceStringCharacter, 0);
            count = count + 1;
            hashMapSource.put(sourceStringCharacter, count);

            char targetStringCharacter = t.charAt(i);
            count = hashMapTarget.getOrDefault(targetStringCharacter, 0);
            count = count + 1;
            hashMapTarget.put(targetStringCharacter, count);
        }

        for(Character c : hashMapSource.keySet()){
            if(! hashMapSource.get(c).equals(hashMapTarget.getOrDefault(c, 0))){
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramUsingMergeSort(String s, String t){
       char[] sourceString = s.toCharArray();
       char[] targetString = t.toCharArray();
       mergeSort(sourceString);
       mergeSort(targetString);
       System.out.println("Sorted sourceString is " + Arrays.toString(sourceString));
       if(! Arrays.toString(sourceString).equals(Arrays.toString(targetString))){
           return false;
       }
       return true;
    }

    private void mergeSort(char[] sourceString) {
        System.out.println(Arrays.toString(sourceString));
        if(sourceString.length < 2){
            return;
        }
        int midPoint = sourceString.length/2;
        char[] leftSubArray = Arrays.copyOfRange(sourceString, 0, midPoint);
        char[] rightSubArray = Arrays.copyOfRange(sourceString, midPoint, sourceString.length);
        mergeSort(leftSubArray);
        mergeSort(rightSubArray);
        // this method takes two sorted subarray and merge them. leftSubArray and rightSubArray are two sorted subarrayes.
        merge(sourceString, leftSubArray, rightSubArray);
    }

    private void merge(char[] randomIntegers, char[] leftSubArray, char[] rightSubArray) {
        int i = 0, j=0, k=0;
        int leftSubArrayLength = leftSubArray.length;
        int rightSubArrayLength = rightSubArray.length;
        while(i < leftSubArrayLength && j < rightSubArrayLength) {
            if((leftSubArray[i]) <= (rightSubArray[j])){
                randomIntegers[k] = leftSubArray[i];
                i ++;
                k++;
            }else{
                randomIntegers[k] = rightSubArray[j];
                j ++;
                k++;
            }
        }
        while(i < leftSubArrayLength){
            randomIntegers[k] = leftSubArray[i];
            i ++;
            k++;
        }
        while(j < rightSubArrayLength){
            randomIntegers[k] = rightSubArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        /*String s = "racecar";
        String t = "carrace";
        ValidAnagram va = new ValidAnagram();
        boolean isAnagram = va.isAnagramUsingArrays(s, t);
        Assert.assertTrue(isAnagram);

        String ss="jar";
        String tt="jam";
        isAnagram = va.isAnagramUsingArrays(ss, tt);
        Assert.assertFalse(isAnagram);

        isAnagram = va.isAnagramUsingHashMap(s, t);
        Assert.assertTrue(isAnagram);

        isAnagram = va.isAnagramUsingHashMap(ss, tt);
        Assert.assertFalse(isAnagram);*/

        String s = "racecar";
        String t = "carrace";

        String ss="jar";
        String tt="jam";

        ValidAnagram va = new ValidAnagram();

        boolean isAnagram = va.isAnagramUsingMergeSort(s, t);
        Assert.assertTrue(isAnagram);

        isAnagram = va.isAnagramUsingMergeSort(ss, tt);
        Assert.assertFalse(isAnagram);

    }

}
