package LinkedList;

public class ReorderLinkedList {
    public static void main(String[] args){
        ReorderLinkedList reOrder = new ReorderLinkedList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        //head.next.next.next.next = new ListNode(10);
        reOrder.reorderList(head);
        System.out.println("Output");
        reOrder.printList(head);
    }

    public void reorderList(ListNode head) {
        ListNode temp = head;
        // find the mid of the list using slow-fast pointer approach
        ListNode slow = temp;
        ListNode fast = temp.next;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        System.out.println("slow value is " +slow.val);

        // reverse second half of the linked list
        ListNode head1= temp;
        ListNode head2 = slow.next;
        slow.next = null;
        /*printList(head1);
        printList(head2);*/

        ListNode prev = null;
        ListNode temp2 = head2;
        while(temp2 != null){
            ListNode next = temp2.next;
            temp2.next = prev;
            prev = temp2;
            temp2 = next;
        }
        head2= prev;
        /*printList(head1);
        printList(head2);*/

        System.out.println("End of reversed list");

        // reOrder list by choosing node from first half and second half of the lists sequentially.
        while(head1 != null && head2!= null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = head1.next.next;
            head2=next2;
            //printList(head);
        }
    }

    public void reorderList_BigON2(ListNode head) {
        ListNode temp = head;
        if(temp == null){
            return;
        }
        while(temp.next != null){
            ListNode currentsNext = temp.next;
            temp.next = getLastNodeOfTheList(temp);
            temp = temp.next;
            if(temp != currentsNext){
                temp.next = currentsNext;
                temp = temp.next;
            }
            printList(temp);
        }
    }

    private ListNode getLastNodeOfTheList(ListNode head) {
        ListNode temp = head;
        ListNode prev = temp;
        while(temp.next!= null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return temp;
    }

    private void printList(ListNode head){
        System.out.println("inside print");
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
