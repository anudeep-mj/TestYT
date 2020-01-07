package challenges;

import utils.LinkedListNode;

public class LinkedListStringify {

    public static String stringify(LinkedListNode linkedListNode) {
        if (linkedListNode == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (linkedListNode.getNext() != null) {
            int data = linkedListNode.getData();
            stringBuilder.append(data + " -> ");
            linkedListNode = linkedListNode.getNext();
        }

        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    static int length(LinkedListNode head) {
        if (head == null) {
            return 0;
        }

        int result = 0;
        while (head != null) {
            result++;
            head = head.getNext();
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
