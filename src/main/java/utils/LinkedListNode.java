package utils;

public class LinkedListNode {
    private int data;
    private LinkedListNode next;

    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public LinkedListNode getNext() {
        return next;
    }
}
