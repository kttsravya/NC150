package Stack;

import org.junit.Assert;

import java.util.Stack;

public class ValidParentheses {

    // does not work
    public boolean isValidUsingTwoPointer(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;
        if(s.length() % 2 != 0){
            return false;
        }
        while (startPointer < endPointer) {
            Character c = s.charAt(startPointer);
            Character matchingCharacter = getMatchingCharacter(c);
            Character endCharacter = s.charAt(endPointer);
            if(! endCharacter.equals(matchingCharacter)){
                return false;
            }
            startPointer ++;
            endPointer --;
        }
        return true;
    }

    public boolean isValidUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty() && stack.peek() == getMatchingCharacter(c)) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private Character getMatchingCharacter(Character c) {
        Character unknown = ' ';
        switch (c) {
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return unknown;
        }
    }

    public static void main(String[] args){
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "([{}])";
        boolean isValid = validParentheses.isValidUsingStack(s);
        Assert.assertTrue(isValid);
    }
}
