package Greedy;

import java.util.HashSet;
import java.util.Set;

public class MergeTripletsToFormTarget {
    public static void main(String[] args){
        MergeTripletsToFormTarget merge = new MergeTripletsToFormTarget();
        boolean isMerge = merge.mergeTriplets(new int[][]{{1,2,3},{7,1,1}}, new int[]{7,2,3});
        System.out.println(isMerge);
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> index = new HashSet<>();
        for(int[] currentTriplet : triplets){
            if(currentTriplet[0] > target[0] || currentTriplet[1] > target[1]
            || currentTriplet[2] > target[2]){
                continue;
            }
            for(int i = 0; i < target.length; i ++){
                if(currentTriplet[i] == target[i]){
                    index.add(i);
                }
            }
        }
        return index.size() == target.length;
    }
}
