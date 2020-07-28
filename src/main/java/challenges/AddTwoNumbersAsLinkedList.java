package challenges;
/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

import utils.ListNode;

public class AddTwoNumbersAsLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int remainder = 0;

        ListNode res = new ListNode(-1);
        ListNode tempHead = res;

        while (l1 != null && l2 != null) {
            int l1val = 0;
            int l2val = 0;

            if (l1 != null) {
                l1val = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2val = l2.val;
                l2 = l2.next;
            }

            int sum = l1val + l2val + remainder;

            res.next = new ListNode(sum % 10);
            remainder = sum / 10;

            res = res.next;
        }

        //forgot to take the consideration where there still might be a leftover. eg 9 + 1 => we need to add another node (1)
        //Also rather than doing this at the end, i could have had a check for "|| carry != 0" in the while loop itself.
        if (remainder != 0) {
            res.next = new ListNode(1);
        }

        return tempHead.next;
    }
}
