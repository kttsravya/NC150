package LinkedList;

public class FindDuplicates {
    public static void main(String[] args){
        FindDuplicates duplicates = new FindDuplicates();
        int duplicate = duplicates.findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(duplicate);
    }

    //Floyd's algorithm
   // Step 1: slow pointer move by 1 and fast pointer move by 2 steps. and if they meet, cycle is detected
    // step 2: bring one of the pointer to begining of the list. now move each pointer by 1 step. the point they meet is the start of the cycle.

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        System.out.println("cycle detected at " + slow);

        fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (fast == slow) {
                return slow;
            }
        }
    }
}
