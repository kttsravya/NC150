package Greedy;


import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args){
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        boolean isValid = validParenthesisString.checkValidString_UsingTwoStacks(
                "(*)");
        System.out.println(isValid);
    }

    public boolean checkValidString_UsingTwoStacks(String s){
        Stack<Integer> openBracketIndices = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                openBracketIndices.push(i);
            }
            if(s.charAt(i) == '*'){
                asterisk.push(i);
            }
            if(s.charAt(i) == ')'){
                if(! openBracketIndices.isEmpty()){
                    openBracketIndices.pop();
                }
                else if (! asterisk.isEmpty()){
                    asterisk.pop();
                }else{
                    return false;
                }
            }
        }

        while(! openBracketIndices.isEmpty() && ! asterisk.isEmpty()){
            if(openBracketIndices.pop() > asterisk.pop()){
                return false;
            }
        }
        return openBracketIndices.isEmpty();
    }


    public boolean checkValidString_Recursive(String s){
        Boolean[][] cache = new Boolean[s.length()][s.length()];
        return checkValidString_RecursiveHelper(s, 0,0, cache);
    }

    private boolean checkValidString_RecursiveHelper(String s, int index, int numOpen, Boolean[][] cache) {
        if(s.length() == index){
            return numOpen == 0;
        }
        if(cache[index][numOpen] != null){
            System.out.println("cache hit");
            return cache[index][numOpen];
        }
        boolean isValid = false;
        if(s.charAt(index) == '('){
            isValid = checkValidString_RecursiveHelper(s, index+1, numOpen+1, cache);
        }
        if(s.charAt(index) == ')' && numOpen > 0){
            isValid =  checkValidString_RecursiveHelper(s, index+1, numOpen - 1, cache);
        }
        if(s.charAt(index) == '*'){
            isValid =  checkValidString_RecursiveHelper(s, index+1, numOpen+1, cache) ||
                    (numOpen > 0 && checkValidString_RecursiveHelper(s, index+1, numOpen-1, cache))||
                    checkValidString_RecursiveHelper(s, index+1, numOpen, cache);
        }
        return cache[index][numOpen] = isValid;
    }

    private boolean checkValidString_BottomUp(String s) {
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        dp[s.length()][0] = true;

        for(int index = s.length() - 1; index >= 0; index --){
            for(int numOfOpen = index; numOfOpen >=0; numOfOpen --){
                boolean isValid = false;
                if(s.charAt(index) == '('){
                    isValid = dp[index+1][numOfOpen+1];
                }
                if(s.charAt(index) == ')' && numOfOpen > 0){
                    isValid =  dp[index+1][numOfOpen - 1];
                }
                if(s.charAt(index) == '*'){
                    isValid =  dp[index+1][numOfOpen+1]||
                            (numOfOpen > 0 && dp[index+1][numOfOpen-1])||
                            dp[index+1][numOfOpen];
                }
                dp[index][numOfOpen] = isValid;
            }
        }
        return dp[0][0];
    }
}
