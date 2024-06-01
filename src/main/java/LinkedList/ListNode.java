package LinkedList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReverseList {

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode nextCurrent = current.next;
            current.next = prev;
            prev = current;
            current = nextCurrent;
        }
        return prev;

    }

    public static void main(String[] args){
        int[] nums = {0,1,2,3};
        int[] output = {3,2,1,0};
        ListNode[] linkedNodeList = new ListNode[nums.length];

        for(int i = 0; i < nums.length; i ++){
             ListNode l1 = new ListNode(nums[i]);
             linkedNodeList[i] = l1;
             System.out.println(linkedNodeList[i].val);
        }
        System.out.println("Length is "+linkedNodeList.length);

        for(int i = 0; i < linkedNodeList.length - 1; i ++){
            linkedNodeList[i].next = linkedNodeList[i + 1];
            System.out.println(linkedNodeList[i].val + " " +linkedNodeList[i].next);
        }
        printList(linkedNodeList[0]);
        ReverseList reverseList = new ReverseList();
        ListNode reversedList = reverseList.reverseList(linkedNodeList[0]);
        printList(reversedList);
    }

    private static void printList(ListNode head) {
     while(head != null){
         System.out.print(head.val + ",");
         head = head.next;
     }
     System.out.println();
    }

}
