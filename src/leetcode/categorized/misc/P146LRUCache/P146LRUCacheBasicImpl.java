package leetcode.categorized.misc.P146LRUCache;

import java.util.HashMap;

// Basically here we're going to just implement our own form of linked hash map.
class P146LRUCacheBasicImpl {
    int capacity;
    HashMap<Integer, DoublyLinkedNode> cache;
    DoublyLinkedNode head = new DoublyLinkedNode(0, 0), tail = new DoublyLinkedNode(0, 0);
    // Head and tail are just used as reference nodes
    // Most recently used item will be at head.next and least recently used item will be at tail.prev

    public P146LRUCacheBasicImpl(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        DoublyLinkedNode node = cache.get(key);
        // remove and reinsert the node into cache to make it new MRU node
        remove(node);
        insert(node);
        return node.value;
    }

    private void remove(DoublyLinkedNode nodeBeingRemoved) {
        cache.remove(nodeBeingRemoved.key); // remove it from map.
        nodeBeingRemoved.prev.next = nodeBeingRemoved.next;
        nodeBeingRemoved.next.prev = nodeBeingRemoved.prev;
    }

    private void insert(DoublyLinkedNode nodeBeingInserted) {
        cache.put(nodeBeingInserted.key, nodeBeingInserted);
        // temporarily hold the most recently used(MRU) node before insertion
        DoublyLinkedNode lastMRUNode = head.next;
        // make nodeBeingInserted the new MRU node
        head.next = nodeBeingInserted;
        // make new MRU node point to head pointer.
        nodeBeingInserted.prev = head;
        // place the last MRU node after the new MRU node.
        nodeBeingInserted.next = lastMRUNode;
        // place the new MRU node before the last MRU node
        lastMRUNode.prev = nodeBeingInserted;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));
        else if (cache.size() == capacity) remove(tail.prev);

        insert(new DoublyLinkedNode(key, value));
    }

    private class DoublyLinkedNode {
        int key, value;
        DoublyLinkedNode prev, next;

        DoublyLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}