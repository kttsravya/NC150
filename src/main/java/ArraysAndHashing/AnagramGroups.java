package ArraysAndHashing;

import java.util.*;

public class AnagramGroups {
    public static void main(String[] args){
        AnagramGroups anagramGroups = new AnagramGroups();
        List<List<String>> res = anagramGroups.groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"});
        System.out.println(res.toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String currentStr : strs) {
            int[] sigInt = new int[26];
            for (int currentIndex = 0; currentIndex < currentStr.length(); currentIndex++) {
                int index = currentStr.charAt(currentIndex) - 'a';
                sigInt[index] = sigInt[index] + 1;
            }
            String sigStr = Arrays.toString(sigInt);
            List<String> grpAnagramList = anagramMap.getOrDefault(sigStr, new ArrayList<>());
            grpAnagramList.add(currentStr);
            anagramMap.put(sigStr, grpAnagramList);
        }

        return new ArrayList<>(anagramMap.values());
    }


    /*class keyWrapper implements Comparator {
        int[] inputArray;
        public keyWrapper(int[] kw){
            this.inputArray = kw;
        }

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }

        @Override
        public boolean equals(Object ob){
           if(this == ob){
               return true;
           }
           if(this.getClass() != ob.getClass()){
               return false;
           }
            keyWrapper k = (keyWrapper)ob;

        }*/
    //}
}
