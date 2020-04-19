package challenges;
/**
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list,v we use an integer pos which represents the position (0-indexed) in
 * the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 */

import utils.ListNode;

import java.util.HashSet;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        HashSet<ListNode> seenSet = new HashSet<>();
        while (head != null) {
            if (seenSet.contains(head)) {
                return true;
            } else {
                seenSet.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
