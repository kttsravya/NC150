package HeapsAndPriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args){
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int[] stones = {2, 3, 6, 2, 4};
        int lastStoneWe = lastStoneWeight.lastStoneWeight(stones);
        System.out.println(lastStoneWe);
    }

    public int lastStoneWeight(int[] stones){
        List<Integer> list = new ArrayList<>();
        for(int stone : stones){
            list.add(stone);
        }
        // reverseOrder comparator creates maxHeap
        PriorityQueue maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        maxHeap.addAll(list);

        int heapSize = maxHeap.size();
        while(heapSize >= 2){
            int weight1 = (int) maxHeap.poll();
            int weight2 = (int) maxHeap.poll();
            if(weight1 > weight2){
                int weight3 = weight1 - weight2;
                maxHeap.add(weight3);
                heapSize ++;
            }
            heapSize = heapSize - 2;
        }
        if(maxHeap.isEmpty()){
            return 0;
        }else{
            return (int)maxHeap.poll();
        }
    }


}
