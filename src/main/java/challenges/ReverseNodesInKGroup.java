package challenges;

import utils.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *     Only constant extra memory is allowed.
 *     You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup
{
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempHead = head;
        int count = 0;
        while(count < k && tempHead != null) {
            count++;
            tempHead = tempHead.next;
        }

        if(count == k) {
            ListNode reversedHead = this.reverseListRecursive(head, k);
            head.next = this.reverseKGroup(tempHead, k);
            return reversedHead;
        }

        return head;
    }

    /*
    This function takes a head and reverses the node pointers till k and returns new head
    */
    private ListNode reverseListRecursive(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while(k > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }

        //new head at the end since curr will be pointing to next.
        return prev;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseNodesInKGroup.reverseKGroup(head, 2);
    }
}
