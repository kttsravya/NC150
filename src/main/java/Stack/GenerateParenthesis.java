package Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args){
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> result = generateParenthesis.generateParenthesisWithBackTracking(3);
    }

    public List<String> generateParenthesisWithBackTracking(int n){
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        int openN = 0;
        int closeN = 0;
        generateParenthesisWithBackTrackingHelper(n, openN, closeN, sb, res);
        System.out.println(res);
        return res;
    }

    private void generateParenthesisWithBackTrackingHelper(int n, int openN, int closeN, StringBuilder current, List<String> res) {
        if(openN == n && closeN == n){
            res.add(current.toString());
        }

        if(openN < n){
            current.append("(");
            generateParenthesisWithBackTrackingHelper(n, openN + 1, closeN, current, res);
            current.deleteCharAt(current.length() - 1);
        }

        if(closeN < openN){
            current.append(")");
            generateParenthesisWithBackTrackingHelper(n, openN, closeN+1, current, res);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public List<String> generateParenthesis_BacktrackingWithConditions(int n){
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int openN = 0;
        int closeN = 0;
        generateParenthesisHelper(n, openN, closeN, current, result);
        for(int i = 0; i < result.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(String s: result.get(i)){
                sb.append(s);
            }
            res.add(sb.toString());
        }
        System.out.println(res);
        return res;
    }

    private void generateParenthesisHelper(int n, int openN, int closeN, List<String> current, List<List<String>> result) {
        if((openN == closeN) && (closeN == n )){
            result.add(new ArrayList<>(current));
            return;
        }

        if(openN < n){
            current.add("(");
            generateParenthesisHelper(n, openN + 1, closeN, current, result);
            current.remove(current.size() - 1);
        }

        if(closeN < openN){
            current.add(")");
            generateParenthesisHelper(n, openN, closeN + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    //
    public List<List<Character>> generateParenthesis(int n) {
         StringBuilder sb = new StringBuilder();
         List<Character> list = new ArrayList<>();
         while(n > 0){
             list.add('(');
             list.add(')');
             n --;
         }
         List<List<Character>> result = new ArrayList<>();
         List<Character> current = new ArrayList<>();
         permuationHelper(list, current, result);
         for(int i = 0; i < result.size(); i ++){
             System.out.println(result.get(i).toString());
         }
         return result;
    }

    private void permuationHelper(List<Character> inputList, List<Character> current, List<List<Character>> result) {
        if(inputList.size() == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < inputList.size(); i ++){
            Character removedCharacter = inputList.remove(i);
            current.add(removedCharacter);
            permuationHelper(inputList, current, result);
            current.remove(current.size() - 1);
            inputList.add(removedCharacter);
        }
    }
}
