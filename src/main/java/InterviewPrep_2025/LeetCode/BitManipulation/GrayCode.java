package InterviewPrep_2025.LeetCode.BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrayCode {
    public static void main(String[] args){
        System.out.println(grayCode(3));
    }
    public static List<Integer> grayCode(int n){
        StringBuilder start = new StringBuilder();
        for(int i = 0; i < n; i ++){
            start.append("0");
        }
        List<String> grayCodeSequenceList = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();
        grayCodeSequenceList.add(start.toString());
        seen.add(start.toString());
        List<Integer> grayCodeSequenceResultList = new ArrayList<Integer>();
        if(grayCodeHelper(start, grayCodeSequenceList, seen, n)){
            // print result list
            for(int i = 0; i < grayCodeSequenceList.size(); i ++){
                grayCodeSequenceResultList.add(Integer.parseUnsignedInt(grayCodeSequenceList.get(i),2));
            }
        }
        return grayCodeSequenceResultList;
    }


    private static boolean grayCodeHelper(StringBuilder start, List<String> grayCodeSequenceList, HashSet<String> seen, int n) {
        if(grayCodeSequenceList.size() == (1 << n)){
            /*
            // if number of one's in list.index(7) has only one 1, return true;
            String lastInteger = grayCodeSequenceList.get(grayCodeSequenceList.size() - 1);
            long finInteger = Integer.parseUnsignedInt(lastInteger, 2);
            if((finInteger & (finInteger - 1)) == 0){
                return true;
            }else{
                return false;
            }
             */
            return true;
        }
        for(int i = 0; i < n; i ++){
            char ch = start.charAt(i);
            StringBuilder temp = new StringBuilder(start);
            if(ch == '0'){
                temp.setCharAt(i,'1');
            }else{
                temp.setCharAt(i,'0');
            }
            if(seen.contains(temp.toString())){
                continue;
            }
            grayCodeSequenceList.add(temp.toString());
            seen.add(temp.toString());
            if(grayCodeHelper(temp, grayCodeSequenceList, seen, n)){
                return true;
            }
            seen.remove(grayCodeSequenceList.get(grayCodeSequenceList.size() - 1));
            grayCodeSequenceList.remove(grayCodeSequenceList.size() - 1);
        }
        return false;
    }
}
