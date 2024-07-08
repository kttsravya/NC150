package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args){
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        String test = "aa";
        List<List<String>> res = palindromePartitioning.partition(test);
        System.out.println(res.toString());
    }

    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        partition_BackTracking_Helper(s, current, result,0);
        return result;
    }

    public void partition_BackTracking_Helper(String s, List<String> current, List<List<String>> result, int i){
        if(i == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int j = i; j < s.length(); j ++){
            String subString = s.substring(i, j+1);
            if(isPalindrome(subString)){
                current.add(subString);
                // remainder of the test to pass it to dfs function
                //String sub = s.substring(i);
                partition_BackTracking_Helper(s, current, result, j+1);
                current.remove(current.size() - 1);
            }
        }
    }

   /* public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        Set<List<String>> hashSet = new HashSet<>();
        for(int i = 0; i < s.length(); i ++){
            List<String> res = null;
            if(i > 0){
                res = partitionHelper((s.substring(0, i)));
            }
            List<String> result = partitionHelper(s.substring(i));
            if(res != null){
                result.addAll(0, res);
            }
            if(! hashSet.contains(result)){
                resultList.add(result);
                hashSet.add(result);
            }
        }
       return resultList;
    }

    private List<String> partitionHelper(String s) {
        int i = 0;
        List<String> currentResult = new ArrayList<>();
        while (i < s.length()){
            int index = s.indexOf(s.charAt(i),i+1);
            if(index == -1 || ! isPalindrome(s.substring(i, index+1))){
                currentResult.add(String.valueOf(s.charAt(i)));
                i = i + 1;
            }else{
                currentResult.add(s.substring(i, index + 1));
                i = index+1;
            }
        }
        return currentResult;
    }*/

    private boolean isPalindrome(String substring) {
        System.out.println("isPalindrome " + substring);
        int start = 0;
        int end = substring.length() - 1;
        while(start<=end){
            if(substring.charAt(start) ==substring.charAt(end)){
                start ++;
                end --;
            }else{
                return false;
            }
        }
        return true;
    }
}
