package SlidingWindow.educativePattern;

//neetcode video-python
import java.util.*;
import java.util.stream.IntStream;

public class FindMaxInKWindowSize {
    public static void main(String[] args){
        int[] rsult = FindMaxInKWindowSize.findMaxInSlidingWindowEasyCoding(new int[]{1,2,3,4,5,6,7,8,9,10}, 3);
        // code editior
        Arrays.sort(rsult);
        System.out.println(Arrays.toString(rsult));

    }

    // using monotonically decreasing dequeue and easy coding
    public static int[] findMaxInSlidingWindowEasyCoding(int[] nums, int w) {
        ArrayDeque<Integer> dequeue = new ArrayDeque<Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < w; i ++){
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]){
                dequeue.pollLast();
            }
            dequeue.offer(i);
        }
        result.add(nums[dequeue.peekFirst()]);


        for(int i = w; i < nums.length; i ++){
            if(dequeue.peekFirst() == i - w){
                dequeue.pollFirst();
            }
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]){
                dequeue.pollLast();
            }
            dequeue.offer(i);
            result.add(nums[dequeue.peekFirst()]);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    // using monotonically decreasing dequeue
    public static int[] findMaxInSlidingWindow(int[] nums, int w) {
         ArrayDeque<Integer> dequeue = new ArrayDeque<Integer>();
         ArrayList<Integer> result = new ArrayList<>();
         int left = 0;
        for(int right = 0; right < nums.length; right ++){

            // maintaining monotonic queue
            while (! dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[right]){
                dequeue.pollLast();
            }
            dequeue.add(right);
            System.out.println("current deque state is "+dequeue.toString());

            // maintaining window size
            if(right - left >= w - 1){
                System.out.println("maintaining window size");
                result.add(nums[dequeue.peekFirst()]);
                if(dequeue.peekFirst() != null && dequeue.peekFirst() <= left){
                    dequeue.pollFirst();
                }
                left++;
            }
        }
        return result.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }

    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer,Integer> maxOccurence = new TreeMap<>();
        int left = 0;
        for(int right = 0; right < nums.length; right ++){
            if(right < w){
                maxOccurence.put(nums[right], maxOccurence.getOrDefault(nums[right], 0)+1);
                continue;
            }
            // retrieve max element and add to result
            Map.Entry<Integer, Integer> maxValueEntry = maxOccurence.lastEntry();
            System.out.println("max element when right is "+ right + " is"+ maxValueEntry.getKey());
            result.add(maxValueEntry.getKey());

            // Now, window size is w. so, remove left most element and expand window by one element to the right to maintain size of w
            int leftFrequency = maxOccurence.getOrDefault(nums[left], 0);
            if(leftFrequency - 1 == 0){
                maxOccurence.remove(nums[left]);
            }else{
                maxOccurence.put(nums[left], leftFrequency - 1);
            }
            left ++;
            maxOccurence.put(nums[right], maxOccurence.getOrDefault(nums[right], 0)+1);
        }
        result.add(maxOccurence.lastKey());

        return result.stream().mapToInt(i -> i).toArray();
    }
}
