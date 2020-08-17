package challenges;

import utils.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII
{
    public ListNode reverseBetween (ListNode head, int m, int n)
    {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;

        ListNode cur1 = dummy;
        ListNode pre1 = null;

        //pre1 will point to node before m and cur1 will be pointing to m
        for (int i = 0; i < m; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        //reverse
        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        ListNode temp;

        for (int i = m; i < n; i++) {
            temp = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = temp;
        }

        //set up the final pointers
        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }
}
