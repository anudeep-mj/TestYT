package challenges;

import utils.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int tempN = n;
        ListNode tempHead = head;
        ListNode result = head;
        while (tempN >= 0) {
            if (tempHead == null) {
                return new ListNode(-1);
            }
            //4
            tempHead = tempHead.next;
            //-1
            tempN--;
        }

        while (tempHead != null) {
            //null
            tempHead = tempHead.next;
            //3
            head = head.next;
        }

        head.next = head.next.next;

        return result;
    }
}
