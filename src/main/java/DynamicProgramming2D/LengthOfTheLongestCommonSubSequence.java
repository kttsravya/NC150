package DynamicProgramming2D;

import java.util.Arrays;
import java.util.HashMap;

public class LengthOfTheLongestCommonSubSequence {
    public static void main(String[] args) {
        LengthOfTheLongestCommonSubSequence longestCommonSubsequence = new LengthOfTheLongestCommonSubSequence();
     /* String text1= "mhunuzqrkzsnidwbun";
      String text2 = "szulspmhwpazoxijwbq";
*/
        String text1 = "mhunuzqrkzsnidwbun";
        String text2 = "szulspmhwpazoxijwbq";
        int longest = longestCommonSubsequence.longestCommonSubsequence_BottomsUp_PureDP(text1, text2);
        System.out.println(longest);
    }

    // *** Sliding window solution has some bug and not working
   /* public int longestCommonSubsequenceSlidingWindow(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        if (text1.equals(text2)) {
            return text1.length();
        }
        String stringOne;
        String stringTwo;
        if (text1.length() > text2.length()) {
            stringOne = text2;
            stringTwo = text1;
        } else {
            stringOne = text1;
            stringTwo = text2;
        }
        int max = 0;
        for (int i = 0; i < stringOne.length(); i++) {
            max = Math.max(max, getCountOfLongestCommonSubSequence(stringOne.substring(i), stringTwo));
        }
        return max;
    }

    private int getCountOfLongestCommonSubSequence(String stringOne, String stringTwo) {
        System.out.println("StringOne and String2 are " + stringOne + " " + stringTwo);
        int stringOnePointer = 0;
        int stringTwoStartPointer = 0;
        int stringTwoEndPointer = stringTwoStartPointer;
        int longestCommonSubSequence = 0;

        while (stringOnePointer < (stringOne.length()) && stringTwoEndPointer < stringTwo.length()) {

            if (stringOne.charAt(stringOnePointer) == stringTwo.charAt(stringTwoEndPointer)) {
                System.out.println("matched characters " + stringOne.charAt(stringOnePointer));
                stringOnePointer++;
                stringTwoEndPointer++;
                stringTwoStartPointer = stringTwoEndPointer;
                longestCommonSubSequence++;
            } else {
                if (stringTwoEndPointer < stringTwo.length() - 1) {
                    stringTwoEndPointer++;
                } else {
                    stringOnePointer++;
                    stringTwoEndPointer = stringTwoStartPointer;
                }
            }
        }
        return longestCommonSubSequence;
    }
*/
    public int longestCommonSubsequenceUsingRecursion_Memoization(String text1, String text2) {
        int text1Pointer = 0;
        int text2Pointer = 0;
        HashMap<IntArrayWrapper, Integer> hashmap = new HashMap<>();
        int LCS = longestCommonSubSequenceHelper(text1, text2, text1Pointer, text2Pointer, hashmap);
        System.out.println(LCS);
        return LCS;
    }

    private int longestCommonSubSequenceHelper(String text1, String text2, int text1Pointer, int text2Pointer,
                                               HashMap<IntArrayWrapper, Integer> map) {
        if (text1Pointer >= text1.length() || text2Pointer >= text2.length()) {
            return 0;
        }
        if (map.containsKey(new IntArrayWrapper(new int[]{text1Pointer, text2Pointer}))) {
            //System.out.println("retrieving from map");
            return map.get(new IntArrayWrapper(new int[]{text1Pointer, text2Pointer}));
        }
        int lcs = 0;
        if (text1.charAt(text1Pointer) == text2.charAt(text2Pointer)) {
            lcs = 1 + longestCommonSubSequenceHelper(text1, text2, text1Pointer + 1, text2Pointer + 1, map);
            System.out.println("matching characters are " + text1.charAt(text1Pointer));
        } else {
            lcs = Math.max(longestCommonSubSequenceHelper(text1, text2, text1Pointer + 1, text2Pointer, map),
                    longestCommonSubSequenceHelper(text1, text2, text1Pointer, text2Pointer + 1, map));
        }
        map.put(new IntArrayWrapper(new int[]{text1Pointer, text2Pointer}), lcs);
        return lcs;
    }

    public int longestCommonSubsequence_BottomsUp_PureDP(String text1, String text2) {
        // adding extra row and col and initializing with zeros to catch boundary cases
        int[][] lcs = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    lcs[i][j] = 1 + lcs[i + 1][j + 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
                }
            }
        }
        return lcs[0][0];
    }

    class IntArrayWrapper {
        private final int[] array;

        public IntArrayWrapper(int[] array) {
            this.array = array;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntArrayWrapper that = (IntArrayWrapper) o;
            return Arrays.equals(array, that.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }
    }
}
