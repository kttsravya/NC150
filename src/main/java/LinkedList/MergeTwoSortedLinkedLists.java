package LinkedList;

public class MergeTwoSortedLinkedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // creating dummy node
        ListNode mergedListHead = new ListNode();
        ListNode mergedListPointer = mergedListHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mergedListPointer.next = list1;
                list1 = list1.next;
            } else {
                mergedListPointer.next = list2;
                list2 = list2.next;
            }
            mergedListPointer = mergedListPointer.next;
        }
        if(list1 != null){
            mergedListPointer.next = list1;
        }
        if(list2 != null){
            mergedListPointer.next = list2;
        }
        return mergedListHead.next;
    }

    public static void main(String[] args){
        MergeTwoSortedLinkedLists msl = new MergeTwoSortedLinkedLists();

        int[] list1 = {1,2,4};
        int[] list2 = {1,3,5};
        ListNode[] linkedNodeList = new ListNode[list1.length];

        for(int i = 0; i < list1.length; i ++){
            ListNode l1 = new ListNode(list1[i]);
            linkedNodeList[i] = l1;
            //System.out.println(linkedNodeList[i].value);
        }
        System.out.println("Length is "+linkedNodeList.length);

        for(int i = 0; i < linkedNodeList.length - 1; i ++){
            linkedNodeList[i].next = linkedNodeList[i + 1];
            //System.out.println(linkedNodeList[i].value + " " +linkedNodeList[i].next);
        }
        //printList(linkedNodeList[0]);

        ListNode[] linkedNodeList2 = new ListNode[list2.length];

        for(int i = 0; i < list1.length; i ++){
            ListNode l1 = new ListNode(list2[i]);
            linkedNodeList2[i] = l1;
            //System.out.println(linkedNodeList2[i].value);
        }
        System.out.println("Length is "+linkedNodeList2.length);

        for(int i = 0; i < linkedNodeList2.length - 1; i ++){
            linkedNodeList2[i].next = linkedNodeList2[i + 1];
            //System.out.println(linkedNodeList2[i].value + " " +linkedNodeList2[i].next);
        }
        //printList(linkedNodeList2[0]);

       ListNode mergedList = msl.mergeTwoLists(linkedNodeList[0], linkedNodeList2[0]);
       printList(mergedList);
    }

    private static void printList(ListNode head) {
        while(head != null){
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }
}
