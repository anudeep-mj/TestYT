package challenges;

import utils.ListNode;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        if(head.next.next == null) {
            return head.next;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        int count = 0;
        while(fastPtr.next != null && fastPtr.next.next != null) {
            //System.out.println(fastPtr.val);
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            count++;
        }
        //System.out.println("count:" + count);
        if(fastPtr.next == null) {
            return slowPtr;
        } else {
            return slowPtr.next;
        }
    }
}
