package LeetCode.WalmartLabs_3Months_EMH;

public class MiddleOfLinkedList {
    public static void main(String[] args){

    }

    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head, fastPointer = head.next;
        while (fastPointer != null){
            fastPointer = fastPointer.next;
            if(fastPointer != null){
                fastPointer = fastPointer.next;
            }
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
