package challenges;

import utils.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
 * along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int maxValueResult = Integer.MIN_VALUE;
        getMaxPathSum(root, maxValueResult);
        return maxValueResult;
    }

    private int getMaxPathSum(TreeNode root, int maxValueResult) {
        if (root == null) {
            return 0;
        }

        int left = getMaxPathSum(root.getLeft(), maxValueResult);
        int right = getMaxPathSum(root.getRight(), maxValueResult);

        maxValueResult = Math.max(maxValueResult, left + right + root.getVal());
        return maxValueResult;
    }
}
