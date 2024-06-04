package HeapsAndPriorityQueue;

import java.util.*;

public class KthLargest {
    int k;
    PriorityQueue minHeap;

    public KthLargest(int k, int[] nums){
      this.k = k;
      List<Integer> arrayList = new ArrayList<>();
      for(int item : nums){
          arrayList.add(item);
      }
      // priority queue by default creates min heap implementation.
      // If wanted to initialize max heap need to pass in the appropriate comparator.
      this.minHeap = new PriorityQueue<Integer>(arrayList);
      int queueSize = minHeap.size();
      while(queueSize > k){
          // poll method removes the least value every time, since this is min heap.
          minHeap.poll();
          queueSize --;
      }
    }

    public int add(int val){
        boolean isAdded = minHeap.offer(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return (int) minHeap.peek();
    }


    public static void main(String[] args){
        int[] nums = {1, 2, 3, 3};
        int k = 3;
        KthLargest kthLargest = new KthLargest(k, nums);

        int kthLargestElement = kthLargest.add(7);
        System.out.println("kthLargestElement is "+ kthLargestElement);
    }
}
