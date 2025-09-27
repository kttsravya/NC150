package LeetCode.GraphExploreCard;

import java.util.*;

public class SmallestStringWithSwaps {
    public static void main(String[] args){
        SmallestStringWithSwaps stringWithSwaps = new SmallestStringWithSwaps();
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(0);
        pair1.add(3);
        List<Integer> pair2 = new ArrayList<>();
        pair2.add(1);
        pair2.add(2);
        List<List<Integer>> list = new ArrayList<>();
        list.add(pair1);
        list.add(pair2);
        String res = stringWithSwaps.smallestStringWithSwaps("dcab", list);
        System.out.println(res);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind unionFind = new UnionFind(s.length());
        for(List<Integer> pair : pairs){
            unionFind.union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Integer>> rootAndCorrespondingVertices = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            int root = unionFind.find(i);
           List<Integer> list =  rootAndCorrespondingVertices.getOrDefault(root, new ArrayList<>());
           list.add(i);
           rootAndCorrespondingVertices.put(root, list);
        }
        char[] input = new char[s.length()];
        for(List<Integer> curList : rootAndCorrespondingVertices.values()){
            Character[] charArray = new Character[curList.size()];
            for(int i = 0; i < curList.size(); i ++){
                charArray[i] = s.charAt(curList.get(i));
            }
            Arrays.sort(charArray);
            for(int i = 0; i < curList.size(); i ++){
                input[curList.get(i)] = charArray[i];
            }
        }
        return String.valueOf(input);
    }
}
