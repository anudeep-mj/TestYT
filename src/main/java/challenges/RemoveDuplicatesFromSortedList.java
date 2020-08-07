package challenges;

import utils.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList
{
    public ListNode deleteDuplicates (ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while (fastPtr != null) {
            if (fastPtr.val != slowPtr.val) {
                slowPtr.next = fastPtr;
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            else {
                fastPtr = fastPtr.next;
            }
        }

        if (slowPtr.next != fastPtr) {
            slowPtr.next = fastPtr;
        }

        return head;
    }
}
