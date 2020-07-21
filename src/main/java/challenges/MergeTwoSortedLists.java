package challenges;

import utils.ListNode;

/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    //recursive
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return recHelper(l1, l2);
    }

    private ListNode recHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = recHelper(l1.next, l2);
            return l1;
        } else {
            l2.next = recHelper(l1, l2.next);
            return l2;
        }
    }

    //Iterative
    public ListNode mergeTwoListsIter(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode temp = new ListNode(-1);
        ListNode tempHead = temp;

        //mistake: had OR here
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }

        return tempHead.next;
    }
}
