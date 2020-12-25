package challenges;

import utils.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapPairs
{
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode currNext = curr.next;
            ListNode currNextNext = curr.next.next;

            currNext.next = currNextNext.next;

            currNextNext.next = currNext;

            curr.next = currNextNext;
        }

        return head;
    }

    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        head.next = swapPairsRecursive(head.next.next);
        temp.next = head;
        return temp;
    }
}
