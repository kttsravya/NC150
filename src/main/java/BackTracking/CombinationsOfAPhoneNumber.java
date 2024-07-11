package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationsOfAPhoneNumber {
    public static void main(String[] args){
        CombinationsOfAPhoneNumber combinationsOfAPhoneNumber = new CombinationsOfAPhoneNumber();
        List<String> result = combinationsOfAPhoneNumber.letterCombinations("");
        System.out.println(result.toString());
    }

    public List<String> letterCombinations(String digits) {
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        List<String> result= new ArrayList<>();
        if(digits.isBlank()){
            return result;
        }
        Map<Character, String> digitLetterMappings = new HashMap<>();
        digitLetterMappings.put('2',"abc");
        digitLetterMappings.put('3', "def");
        digitLetterMappings.put('4', "ghi");
        digitLetterMappings.put('5', "jkl");
        digitLetterMappings.put('6',"mno");
        digitLetterMappings.put('7',"pqrs");
        digitLetterMappings.put('8',"tuv");
        digitLetterMappings.put('9',"wxyz");
        letterCombinationsHelper(digits, index, stringBuilder,digitLetterMappings,result);
        return result;
    }

    private void letterCombinationsHelper(String digits, int index, StringBuilder stringBuilder,
                                          Map<Character, String> digitLetterMappings, List<String> result) {
        if(index == digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        String letters = digitLetterMappings.get(digits.charAt(index));
        for(int i = 0; i < letters.length(); i ++){
           stringBuilder.append(letters.charAt(i));
           letterCombinationsHelper(digits, index + 1, stringBuilder, digitLetterMappings, result);
           stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
