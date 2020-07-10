package challenges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels.
 * The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level,
 * where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 * Input:
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Example 2:
 * Input:
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 *
 * Example 3:
 * Input:
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 *
 * Example 4:
 * Input:
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int max = 0;
        int start = 0;
        int end = 0;

        Map<TreeNode, Integer> idxmap = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        idxmap.put(root, 1);

        while(!q.isEmpty()) {
            //List<TreeNode> list = new ArrayList<>();
            int qsize = q.size();

            for(int i = 0; i < qsize; i++) {

                TreeNode popped = q.poll();
                if(i == 0) {
                    start = idxmap.get(popped);
                }
                if(i == qsize - 1) {
                    end = idxmap.get(popped);
                }

                if(popped.left != null) {
                    q.offer(popped.left);
                    idxmap.put(popped.left, idxmap.get(popped) * 2);
                }

                if(popped.right != null) {
                    q.offer(popped.right);
                    idxmap.put(popped.right, (idxmap.get(popped) * 2) + 1);
                }
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
