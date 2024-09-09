package LeetCode.WalmartLabs_3Months_EMH;

public class MaximumLengthSubStringWithTwoCharacters {
    public static void main(String[] args){
        MaximumLengthSubStringWithTwoCharacters maximumLengthSubStringWithTwoCharacters = new MaximumLengthSubStringWithTwoCharacters();
        int max = maximumLengthSubStringWithTwoCharacters.maximumLengthSubstring("bcbbbcba");
        System.out.println(max);
    }

    public int maximumLengthSubstring(String s) {
        int[] frequency = new int[26];
        int max = Integer.MIN_VALUE;
        int startPointer = 0;
        for(int i = 0; i < s.length(); i ++){
            int index = s.charAt(i) - 'a';
            while (frequency[index] >= 2){
                int startIndex = s.charAt(startPointer) - 'a';
                frequency[startIndex] = frequency[startIndex] - 1;
                startPointer ++;
            }
            frequency[index] = frequency[index] + 1;
            max = Math.max(max, (i - startPointer) + 1);
        }
        return max;
    }
}
