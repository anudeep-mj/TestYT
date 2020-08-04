package challenges;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
    Map<Integer, Node> lruMap;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.lruMap = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cap = capacity;
    }

    public int get(int key) {
        if(this.lruMap.containsKey(key)) {
            Node n = this.lruMap.get(key);
            moveNodeToFront(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        //if key exists, update node, map and move node to front
        //if key doest exist, create node at front and remove last node if over capacity;
        if(lruMap.containsKey(key)) {
            Node n = lruMap.get(key);
            n.val = value;
            moveNodeToFront(n);
        } else {
            Node newNode = new Node(key, value);
            lruMap.put(key, newNode);
            addNodeToFront(newNode);
            if(lruMap.size() > this.cap) {
                removeLastNode();
            }
        }
    }

    private void removeLastNode() {
        Node beforeTail = this.tail.prev;
        Node temp = beforeTail.prev;
        temp.next = this.tail;
        this.tail.prev = temp;
        beforeTail.prev = null;
        beforeTail.next = null;
        this.lruMap.remove(beforeTail.key);
    }

    private void addNodeToFront(Node n) {
        Node nextToHead = this.head.next;
        this.head.next = n;
        n.prev = this.head;
        n.next = nextToHead;
        nextToHead.prev = n;
    }

    private void moveNodeToFront(Node n) {
        if(!n.prev.equals(this.head)) {
            Node prev = n.prev;
            Node nextToN = n.next;

            prev.next = nextToN;
            prev.prev = n;
            nextToN.prev = prev;

            n.prev = this.head;
            n.next = this.head.next;
            this.head.next = n;
        }
    }

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);
    }
}
