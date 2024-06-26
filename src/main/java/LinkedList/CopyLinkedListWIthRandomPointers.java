package LinkedList;


import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWIthRandomPointers {
    public static void main(String[] args){
        CopyLinkedListWIthRandomPointers copy = new CopyLinkedListWIthRandomPointers();
        //head = [[3,null],[7,3],[4,0],[5,1]]
        Node head = new Node(1);
        Node next = new Node(2);
        Node nextNext = new Node(3);
        head.next = next;
        head.next.next = nextNext;
        head.random = null;
        head.next.random = head.next.next;
        head.next.next.random = head.next.next;
        copy.copyRandomList(head);
        while(head != null){
            System.out.print(head.val);
            if(head.random != null){
                System.out.print(" "+head.random.val);
            }
            head = head.next;
            System.out.println();
        }
    }

    public Node copyRandomList(Node head) {
        // First pass: create a copies and map them to refer to original nodes
        Node temp = head;
        Map<Node, Node> oldToNewNodeMapping = new HashMap();
        while (temp != null){
            Node copy = new Node(temp.val);
            oldToNewNodeMapping.put(temp, copy);
            temp = temp.next;
        }
        // Second pass
        temp = head;
        while(temp != null){
            Node copy = oldToNewNodeMapping.get(temp);
            if(temp.next != null){
                copy.next = oldToNewNodeMapping.get(temp.next);
            }
            if(temp.random != null){
                copy.random = oldToNewNodeMapping.get(temp.random);
            }
            temp = temp.next;
        }
        return oldToNewNodeMapping.get(head);
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
