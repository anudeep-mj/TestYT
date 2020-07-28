package challenges;
/**
 * Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * <p>
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 */

import utils.NaryNode;

public class MaximumDepthOfNaryTree {
    int mx = 0;

    public int maxDepth(NaryNode root) {
        mxDepthDFS(root, 1);
        return mx;
    }

    private void mxDepthDFS(NaryNode node, int depth) {
        if (node == null) {
            return;
        }

        if (node.children.size() == 0) {
            mx = Math.max(mx, depth);
            return;
        }

        for (NaryNode n : node.children) {
            mxDepthDFS(n, depth + 1);
        }
    }
}
