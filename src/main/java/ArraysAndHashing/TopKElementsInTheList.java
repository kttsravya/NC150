package ArraysAndHashing;

import java.util.*;

public class TopKElementsInTheList {
    public static void main(String[] args) {
        TopKElementsInTheList topKElementsInTheList = new TopKElementsInTheList();
        int[] res = topKElementsInTheList.topKFrequentUsingBucketSort(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3}, 2);
        System.out.println("result is " + Arrays.toString(res));
    }

    // Using HashMap and Heap
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numAndCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = numAndCountMap.getOrDefault(nums[i], 0);
            count = count + 1;
            numAndCountMap.put(nums[i], count);
        }

        // creates max priority queue, and using second element in the array for ordering.
        PriorityQueue<int[]> topKFrequentPriorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });


        for (int num : numAndCountMap.keySet()) {
            int[] numAndFrequency = new int[]{num, numAndCountMap.get(num)};
            System.out.println(num + "  " + numAndCountMap.get(num));
            topKFrequentPriorityQueue.add(numAndFrequency);
        }

        List<Integer> topKFrequentList = new ArrayList<>();
        while (k > 0) {
            int[] frequent = topKFrequentPriorityQueue.poll();
            System.out.println("Top Frequent element is " + Arrays.toString(frequent));
            if (frequent != null) {
                topKFrequentList.add(frequent[0]);
            }
            k--;
        }
        return topKFrequentList.stream().mapToInt(Integer::intValue).toArray();
    }

    // Using HashMap and BucketSort
    public int[] topKFrequentUsingBucketSort(int[] nums, int k) {
        HashMap<Integer, Integer> numAndCountMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = numAndCountMap.getOrDefault(nums[i], 0);
            count = count + 1;
            numAndCountMap.put(nums[i], count);
        }

        // Create a bucket list with size of input array, each bucket points to frequency of element in input array.
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : numAndCountMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            for (int n : buckets[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

}
