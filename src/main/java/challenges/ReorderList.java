package challenges;
/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

import utils.ListNode;

public class ReorderList {
    public ListNode reorderList(ListNode head) {
        //first get mid
        ListNode mid = head;
        ListNode temp = head;
        while (temp.next != null && temp.next.next != null) {
            mid = mid.next;
            temp = temp.next.next;
        }

        //reverse from head
        mid = reverseList(mid);

        //mix the two halves
        ListNode tempHead = head;
        ListNode tempMiddle = mid.next;
        mixTheTwoHalvesX(tempHead, tempMiddle);

        return head;
    }

    //this wont work because there is no cutoff to two lists
    private void mixTheTwoHalvesX(ListNode head, ListNode mid) {
        ListNode tempMid = null;
        ListNode tempHead = null;
        while (head != null && mid != null) {
            tempMid = mid.next;
            tempHead = head.next;
            head.next = mid;
            mid.next = tempHead;
            head = tempHead;
            mid = tempMid;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempHead = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = tempHead;
        }

        return dummy;
    }

    public static void main(String[] args) {

    }
}
