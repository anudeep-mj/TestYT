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
    int maxValueResult = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxValueResult;
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, getMaxPathSum(root.getLeft()));
        int right = Math.max(0, getMaxPathSum(root.getRight()));
        maxValueResult = Math.max(maxValueResult, left + right + root.getVal());

        //we dont return maxValueResult in this result tree because what we want is not the sum of both nodes below. because that part is take care aboe in like 48
        return Math.max(left, right) + root.getVal();
    }
}
