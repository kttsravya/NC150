package LinkedList;

public class FindDuplicates {
    public static void main(String[] args){
        FindDuplicates duplicates = new FindDuplicates();
        int duplicate = duplicates.findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(duplicate);
    }

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
