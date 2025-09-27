package Greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HandOfStraights {
    public static void main(String[] args){
        HandOfStraights handOfStraights = new HandOfStraights();
        boolean isStraightHand = handOfStraights.isNStraightHand(new int[]{8,10,12}, 3);
        System.out.println(isStraightHand);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        int numGroups = hand.length / groupSize;
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < hand.length; i ++){
            int currentElementFreq = frequencyCount.getOrDefault(hand[i], 0);
            frequencyCount.put(hand[i], currentElementFreq+1);
        }
        Set<Integer> keySet = frequencyCount.keySet();
        for(int key: keySet){
            minHeap.offer(key);
        }
        while (numGroups > 0){
            int currentMin = minHeap.poll();
            while (frequencyCount.get(currentMin) > 0){
                int tempMin = currentMin;
                int tempGrpSize = groupSize;
                while (tempGrpSize > 0){
                    if(frequencyCount.getOrDefault(tempMin, 0) <= 0){
                        return false;
                    }
                    frequencyCount.put(tempMin, frequencyCount.get(tempMin) - 1);
                    tempMin++;
                    tempGrpSize--;
                }
                numGroups --;
            }
        }
        return true;
    }

    private void printMap(Map<Integer, Integer> frequencyCount) {
        for(Map.Entry<Integer, Integer> entry: frequencyCount.entrySet()){
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }
    }

}
