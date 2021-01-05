package challenges;

import utils.ListNode;

/**
 * Given a non-negative integer represented as a linked list of digits, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example 1:
 * Input: head = [1,2,3]
 * Output: [1,2,4]
 *
 * Example 2:
 * Input: head = [0]
 * Output: [1]
 *
 * Constraints:
 *     The number of nodes in the linked list is in the range [1, 100].
 *     0 <= Node.val <= 9
 *     The number represented by the linked list does not contain leading zeros except for the zero itself.
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode notNine = dummy;

        while (head != null) {
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }

        notNine.val++;
        notNine = notNine.next;

        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }

        return dummy.val == 0 ? dummy.next : dummy;
    }
}
