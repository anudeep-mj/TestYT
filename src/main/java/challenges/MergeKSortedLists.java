package challenges;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int totalLists = lists.length;
        int nextNullCount = 0;
        PriorityQueue<ListNode> listNodePriorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode1, ListNode listNode2) {
                if (listNode1.val > listNode2.val) {
                    return 1;
                } else if (listNode1.val == listNode2.val) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < totalLists; i++) {
            ListNode listNode = lists[i];
            while (listNode.next != null) {
                listNodePriorityQueue.add(listNode);
            }
        }

        ListNode dummy = new ListNode(-1);
        while(!listNodePriorityQueue.isEmpty()) {
            ListNode poppedNode = listNodePriorityQueue.poll();
            dummy.next = poppedNode;
        }

        return dummy.next;
    }
}
