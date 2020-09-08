package challenges;
/**
 * Given two binary search trees root1 and root2.
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 * Example 1:
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 *
 * Example 2:
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 *
 * Example 3:
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 *
 * Example 4:
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 *
 * Example 5:
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 *
 * Constraints:
 *     Each tree has at most 5000 nodes.
 *     Each node's value is between [-10^5, 10^5].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return new ArrayList<>();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        addNodeToPQ(root1, pq);
        addNodeToPQ(root2, pq);

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }

    private void addNodeToPQ(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) {
            return;
        }

        pq.add(root.val);
        addNodeToPQ(root.left, pq);
        addNodeToPQ(root.right, pq);
    }
}
