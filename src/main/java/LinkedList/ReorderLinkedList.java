package LinkedList;

public class ReorderLinkedList {
    public static void main(String[] args){
        ReorderLinkedList reOrder = new ReorderLinkedList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        //head.next.next.next.next = new ListNode(10);
        reOrder.reorderListRevOptimized(head);
        System.out.println("Output");
        reOrder.printList(head);
    }


    public void reorderListRevOptimized(ListNode head) {
        // find the mid of the list using fast-slow pointer approach
        // reverse the second half of the list
        // now merge two lists
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != null){
            fastPointer = fastPointer.next;
            if(fastPointer != null){
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }

        ListNode head2 = slowPointer.next;
        slowPointer.next = null;
        //System.out.println("head2 is " + head2.val);

        //reverse the list
        ListNode prev = null;
        while (head2 != null){
            ListNode head2Next = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = head2Next;
        }
        //System.out.println(head.val + " "+ prev.val);
        head2 = prev;

        // merge both the lists
        while(head != null && head2 != null){
            ListNode headNext = head.next;
            ListNode head2Next = head2.next;
            head.next = head2;
            head2.next = headNext;

            head = headNext;
            head2= head2Next;
        }
    }

    //O(n ^ 2)
    public void reorderListRev(ListNode head) {
        int numberOfNodes = 0;
        ListNode temp = head;
        while (temp!= null){
            temp = temp.next;
            numberOfNodes ++;
        }
        if(numberOfNodes < 3){
            return;
        }
        int i = 0;
        temp = head;
        while(i < numberOfNodes/2){
            ListNode lastNode = getLastNode(temp);
            ListNode tempsNext = temp.next;
            temp.next = lastNode;
            lastNode.next = tempsNext;
            temp = tempsNext;
            i++;

        }
    }

    ListNode getLastNode(ListNode current){
        ListNode temp = current.next;
        ListNode prev = current;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return temp;
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


        ListNode prev = null;
        ListNode temp2 = head2;
        while(temp2 != null){
            ListNode next = temp2.next;
            temp2.next = prev;
            prev = temp2;
            temp2 = next;
        }
        head2= prev;

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
