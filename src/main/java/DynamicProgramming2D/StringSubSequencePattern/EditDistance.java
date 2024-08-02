package DynamicProgramming2D.StringSubSequencePattern;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args){
        EditDistance editDistance = new EditDistance();
        int minEditDistance = editDistance.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine");
        System.out.println(minEditDistance);
    }

    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        for(int i = 0; i < cache.length; i ++){
            Arrays.fill(cache[i], -1);
        }
        return minDistanceHelper(word1, word2, 0, 0, cache);
    }

    public int minDistanceHelper(String word1, String word2, int index1, int index2, int[][] cache){
        if(index1 == word1.length() && index2 == word2.length()){
            return 0;
        }
        if(index1 == word1.length()){
            return word2.substring(index2).length();
        }
        if(index2 == word2.length()){
            return word1.substring(index1).length();
        }
        if(cache[index1][index2] > -1){
            return cache[index1][index2];
        }
        int minDistance = 0;
        if(word1.charAt(index1) == word2.charAt(index2)){
          minDistance =   minDistanceHelper(word1, word2, index1+1, index2+1, cache);
        }else{
            minDistance =  Math.min(minDistanceHelper(word1, word2, index1, index2+1, cache),
                    minDistanceHelper(word1, word2, index1+1, index2, cache));
            minDistance =  Math.min(minDistance, minDistanceHelper(word1, word2, index1+1, index2+1, cache));
            minDistance = minDistance+1;
        }
        return cache[index1][index2] = minDistance;
    }
}
