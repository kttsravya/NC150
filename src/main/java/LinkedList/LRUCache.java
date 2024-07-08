package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, DLinkedNode> cacheMap = new HashMap<>();
    DLinkedNode left;
    DLinkedNode right;
    int maxCapacity;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int get(int key) {
        // get from cacheMap
        if (cacheMap.containsKey(key)) {
            // swap key to the right of the dLinkedList
            DLinkedNode node = cacheMap.get(key);
            moveToFarRight(node);
            return node.getValue();
        }
        return -1;
    }

    public int put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            // move to far right and update value
            moveToFarRight(cacheMap.get(key));
            right.setValue(value);
            return right.getValue();
        }

        // if capacity exceeds, delete left from dLinkedList
        if (cacheMap.size() == maxCapacity) {
            deleteLeft();
        }

        // create new DLinkedNode
        DLinkedNode newNode = new DLinkedNode(key, value);

        // add to the right of the list
        addToFarRight(newNode);

        // add key and new node to the cacheMap
        cacheMap.put(key, newNode);
        return value;
    }

    private void deleteLeft() {
        left = left.getNext();
        left.setPrev(null);
    }

    private void addToFarRight(DLinkedNode node) {
        if (right == null) {
            right = node;
            left = node;
        }

        right.setNext(node);
        node.setPrev(right);
        right = right.getNext();
    }

    private void moveToFarRight(DLinkedNode node) {
        // if node is already at far right, don't move
        if (node.getNext() == null) {
            return;
        }

        // if node is on far left
        // TODO

        // connect the left and right of nodes
        DLinkedNode tmpLeft = node.getPrev();
        tmpLeft.setNext(node.getNext());
        node.getNext().setPrev(tmpLeft);

        // connect the node to far right
        addToFarRight(node);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);


        System.out.println("PUT(1,10): " + lruCache.put(1, 10));
        System.out.println("GET(1): " + lruCache.get(1));
        System.out.println("PUT(2,20): " + lruCache.put(2, 20));
        System.out.println("PUT(3,30): " + lruCache.put(3, 30));
        System.out.println("GET(2): " + lruCache.get(2));
        System.out.println("GET(1): " + lruCache.get(1));

    }
}


class DLinkedNode {
    private int key;
    private int value;
    private DLinkedNode prev;
    private DLinkedNode next;

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPrev(DLinkedNode prev) {
        this.prev = prev;
    }

    public void setNext(DLinkedNode next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public DLinkedNode getPrev() {
        return prev;
    }

    public DLinkedNode getNext() {
        return next;
    }
}