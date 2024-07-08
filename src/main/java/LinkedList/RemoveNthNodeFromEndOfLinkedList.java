package LinkedList;

public class RemoveNthNodeFromEndOfLinkedList {

     public static void main(String[] args){
         RemoveNthNodeFromEndOfLinkedList removeNthNode = new RemoveNthNodeFromEndOfLinkedList();
         ListNode node = new ListNode(1);
         node.next = new ListNode(2);
        /* node.next.next = new ListNode(3);
         node.next.next.next = new ListNode(4);*/
         ListNode reformedList =  removeNthNode.removeNthFromEnd(node, 1);
         printList(reformedList);
     }

    private static void printList(ListNode reformedList) {
         ListNode temp = reformedList;
         while (temp != null){
             System.out.println(temp.val);
             temp = temp.next;
         }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Get The size of the list
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size = size + 1;
            temp = temp.next;
        }

        int positionFromStart = size - n;
        temp = head;
        if(positionFromStart == 0){
            return temp.next;
        }
        int counter = 0;
        while(counter < positionFromStart - 1){
            counter++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

}
