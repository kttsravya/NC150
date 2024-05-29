package TwoPointers;

import org.junit.Assert;

import java.util.Locale;

public class ValidPalindrome {

    // use two pointer approach
    // startPointer begins at start of the String
    // endPointer begins at end of the String
    // while traversing, if non-alphanumeric character arrives, ignore it and move the pointer forward if
    // (s.charAt(startPointer) >=65 and s.charAt(startPointer) <=90) || (s.charAt(startPointer) >=97 and (s.charAt(startPointer) <= 122), convert the character to lowercase and consider it for comparision.
    // otherwise, ignore specific character and move forward or backward
    public boolean isPalindrome(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;
        char[] sourceStringCharacters = s.toLowerCase(Locale.ENGLISH).toCharArray();

        while (startPointer < endPointer) {
            while(startPointer < endPointer && ! isAlphaNumericWithoutAsciiCode(sourceStringCharacters[startPointer])){
                startPointer++;
            }
            while (endPointer > startPointer && ! isAlphaNumericWithoutAsciiCode(sourceStringCharacters[endPointer])) {
                endPointer--;
            }

            if(isAlphaNumericWithoutAsciiCode(sourceStringCharacters[startPointer]) && isAlphaNumericWithoutAsciiCode(sourceStringCharacters[endPointer]) && sourceStringCharacters[startPointer] != sourceStringCharacters[endPointer]){
                    return false;
            }
            startPointer ++;
            endPointer --;
            }
        return true;
    }

    public boolean isPalindromeUsingBuiltInMethods(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;

        while(startPointer < endPointer){
            while(startPointer < endPointer && ! Character.isLetterOrDigit(s.charAt(startPointer))){
                startPointer ++;
            }
            while(endPointer > startPointer && ! Character.isLetterOrDigit(s.charAt(endPointer))){
                endPointer --;
            }
            if(Character.isLetterOrDigit(s.charAt(startPointer)) &&
                    Character.isLetterOrDigit(s.charAt(endPointer)) &&
                    Character.toLowerCase(s.charAt(startPointer)) != Character.toLowerCase(s.charAt(endPointer))){
                return false;
            }
            startPointer ++;
            endPointer --;
        }
        return true;
    }

    private boolean isAlphaNumeric(char sourceStringCharacter) {
        if((sourceStringCharacter >= 97 && sourceStringCharacter <= 122) || (sourceStringCharacter >= 48 && sourceStringCharacter <= 57)){
            return true;
        }
        return false;
    }

    private boolean isAlphaNumericWithoutAsciiCode(char sourceStringCharacter) {
        char lowerCaseA = 'a';
        char lowerCaseZ = 'z';
        char upperCaseA = 'A';
        char upperCaseZ = 'Z';
        char digitZero = '0';
        char digitNine = '9';

        if ((lowerCaseA <= sourceStringCharacter && (sourceStringCharacter <= lowerCaseZ)) ||
                (upperCaseA <= sourceStringCharacter && (sourceStringCharacter <= upperCaseZ)) ||
                (digitZero <= sourceStringCharacter && sourceStringCharacter <= digitNine)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String s = "Was it a car or a cat I 0saw?";
        System.out.println(s.toLowerCase(Locale.ENGLISH));
        boolean isPanlindrome = vp.isPalindromeUsingBuiltInMethods(s);
        Assert.assertFalse(isPanlindrome);

        s = "         ";
        System.out.println(s.toLowerCase(Locale.ENGLISH));
        isPanlindrome = vp.isPalindromeUsingBuiltInMethods(s);
        Assert.assertTrue(isPanlindrome);

        s="dddddd";
        System.out.println(s.toLowerCase());
        isPanlindrome = vp.isPalindromeUsingBuiltInMethods(s);
        Assert.assertTrue(isPanlindrome);
    }
}
