package LinkedList;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheSravImpl {
    Map<Integer, DoublyLinkedNode> cache;
    DoublyLinkedNode lruPointer;
    DoublyLinkedNode mruPointer;
    int capacity;

    public LRUCacheSravImpl(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.mruPointer = new DoublyLinkedNode(new int[]{-1, -1});
        this.lruPointer = new DoublyLinkedNode(new int[]{-1, -1});
        this.lruPointer.next = mruPointer;
        this.mruPointer.prev = lruPointer;
    }

    private void remove(DoublyLinkedNode node) {
        DoublyLinkedNode prev = node.prev;
        DoublyLinkedNode next = node.next;
        // unlink current from current location
        prev.next = next;
        next.prev = prev;
    }

    private void insert(DoublyLinkedNode node) {
        // add current to right of the list
        DoublyLinkedNode prev = this.mruPointer.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.mruPointer;
        this.mruPointer.prev = node;
    }

    public int get(int key) {
        // make current element most recently used
        if(cache.containsKey(key)){
            DoublyLinkedNode current = cache.get(key);
            remove(current);
            insert(current);
            return current.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        DoublyLinkedNode current;
        // verify if put operation is called for update
        if(cache.containsKey(key)){
           remove(cache.get(key));
        }else {
            // max capacity reached. remove LRU before adding current.
                if (cache.size() == capacity) {
                    System.out.println("Max capacity reached, remove LRU from map to accommodate new request");
                    // remove from cache
                    DoublyLinkedNode lru = this.lruPointer.next;
                    cache.remove(lru.getKey());
                    // remove from doubly linked list
                    remove(lru);
                    System.out.println("removed entry from cache "+ lruPointer.next.getKey());
                    System.out.println("removed from doubly linked list");
                }
        }
        current = new DoublyLinkedNode(new int[]{key, value});
        cache.put(key, current);
        insert(current);
        }

    public static void main(String[] args) {
        LRUCacheSravImpl lruCacheSravImpl = new LRUCacheSravImpl(2);
        lruCacheSravImpl.get(2);
        lruCacheSravImpl.put(2, 6);
        lruCacheSravImpl.get(1);
        lruCacheSravImpl.put(1, 5);
        lruCacheSravImpl.put(1, 2);
        lruCacheSravImpl.get(1);
        Assert.assertEquals(6, lruCacheSravImpl.get(2));
    }

}

class DoublyLinkedNode {
    int[] keyValue;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;

    DoublyLinkedNode(int[] value) {
        this.keyValue = value;
    }

    public int getValue() {
        return this.keyValue[1];
    }

    public int getKey() {
        return this.keyValue[0];
    }

    public void setValue(int value) {
       this.keyValue[1] = value;
    }
}
