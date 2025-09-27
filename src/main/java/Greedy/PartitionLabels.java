package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args){
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> resultList = partitionLabels.partitionLabels_revised("xyxxyzbzbbisl");
        System.out.println(resultList.toString());
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> elementAndFarIndex = new HashMap<>();
        List<Integer> partitionLength = new ArrayList<>();

        for(int i = 0; i < s.length(); i ++){
            // populate elementAndFarIndex
            elementAndFarIndex.put(s.charAt(i), i);
        }
        int index = 0;
        while(index < s.length()){
            int max = elementAndFarIndex.get(s.charAt(index));
            if(max == index){
                partitionLength.add(1);
                index = index + 1;
            }else{
                int j = index;
                max = elementAndFarIndex.get(s.charAt(index));
                while (j < max){
                    j = j + 1;
                    max = Math.max(max,elementAndFarIndex.get(s.charAt(j)));
                }
                partitionLength.add(j - index + 1);
                index = j+1;
            }
        }
        return partitionLength;
    }

    public List<Integer> partitionLabels_revised(String s) {
        Map<Character, Integer> elementAndFarIndex = new HashMap<>();
        List<Integer> partitionLength = new ArrayList<>();

        for(int i = 0; i < s.length(); i ++){
            // populate elementAndFarIndex
            elementAndFarIndex.put(s.charAt(i), i);
        }

        int size = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i ++){
            size++;
            max = Math.max(max, elementAndFarIndex.get(s.charAt(i)));
            if(i == max){
                partitionLength.add(size);
                size = 0;
            }
        }
        return partitionLength;
    }
}

























