package LinkedList;

import java.util.LinkedList;

public class LinkedListCycleDetection {
    public static void main(String[] args){
        int[] nums = {1,2,3, 4};
        ListNode[] linkedNodeList = new ListNode[nums.length];

        for(int i = 0; i < nums.length; i ++){
            ListNode l1 = new ListNode(nums[i]);
            linkedNodeList[i] = l1;
        }
        System.out.println("Length is "+linkedNodeList.length);

        for(int i = 0; i < linkedNodeList.length - 1; i ++){
            linkedNodeList[i].next = linkedNodeList[i + 1];
        }
        //printList(linkedNodeList[0]);
        linkedNodeList[3].next = linkedNodeList[1];
        //printList(linkedNodeList[0]);
        LinkedListCycleDetection cycleDetection = new LinkedListCycleDetection();
        boolean hasCycle = cycleDetection.hasCycle(linkedNodeList[0]);
        System.out.println("hasCycle: "+hasCycle);
    }

    private static void printList(ListNode head) {
        while(head != null){
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }

    public boolean hasCycle(ListNode head) {
      ListNode p1 = head;
      ListNode p2 = head;

      while(p2 != null){
          p2 = p2.next;
          p1 = p1.next;
          if(p2 != null){
              p2 = p2.next;
          }else{
              return false;
          }
          if(p1 == p2){
              return true;
          }
      }
      return false;
    }
}
