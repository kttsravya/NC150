package LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        //l1.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(6);*/

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        while(result!= null){
            System.out.print(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode head1 = l1;
       ListNode head2 = l2;
       ListNode result = new ListNode(-1);
       ListNode tempResult = result;
       int carry = 0;
       while (head1 != null && head2 != null){
           int val1 = head1.val;
           int val2 = head2.val;
           tempResult.next = new ListNode((val1 + val2 + carry)% 10);
           carry = (val1 + val2 + carry)/10;
           tempResult = tempResult.next;
           head1 = head1.next;
           head2 = head2.next;
       }
       while(head1 != null){
           int val1 = head1.val;
           tempResult.next = new ListNode((val1 + carry)% 10);
           carry = (val1 + carry)/10;
           tempResult = tempResult.next;
           head1 = head1.next;
       }
       while(head2 != null){
           int val2 = head2.val;
           tempResult.next = new ListNode((val2 + carry)% 10);
           carry = (val2 + carry)/10;
           tempResult = tempResult.next;
           head2 = head2.next;
       }
       if(carry > 0){
           tempResult.next = new ListNode(carry);
       }

       return result.next;
    }
}
