package challenges;

import utils.DoublyLinkedNode;

import java.util.Stack;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
 * which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 *
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * https://www.youtube.com/watch?v=ugBx_T1RHuc
 */
public class FlattenMultilevelDoublyLinkedList {
    public DoublyLinkedNode flatten(DoublyLinkedNode head) {
        if(head == null) {
            return null;
        }

        DoublyLinkedNode tempHead = head;
        Stack<DoublyLinkedNode> nodeStack = new Stack<>();

        while (head != null) {
            if (head.child != null) {
                //mistake: missed the null check for next here..
                if (head.next != null) {
                    nodeStack.push(head.next);
                }
                DoublyLinkedNode child = head.child;
                head.child = null;
                head.next = child;
                head.next.prev = head;
            }

            if (head.next == null && !nodeStack.isEmpty()) {
                while (!nodeStack.isEmpty()) {
                    DoublyLinkedNode popped = nodeStack.pop();
                    head.next = popped;
                    head.next.prev = head;
                }
            }

            head = head.next;
        }

        return tempHead;
    }
}
