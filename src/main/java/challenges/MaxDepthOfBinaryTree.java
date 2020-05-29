package challenges;
/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 */

import utils.TreeNode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHt = maxDepth(root.getLeft());
        int rtHt = maxDepth(root.getRight());

        return Math.max(leftHt, rtHt) + 1;
    }

    int maxdepth = 0;

    public int maxDepth2(TreeNode root) {
        getMaxDepth(root, 1);
        return maxdepth;
    }

    public void getMaxDepth(TreeNode node, int maxDepth) {
        if(node == null) {
            return;
        }
        //if(node.left == null && node.right == null) {
        maxdepth = Math.max(maxDepth, maxdepth);
        //}


        getMaxDepth(node.getLeft(), maxDepth + 1);
        getMaxDepth(node.getRight(), maxDepth + 1);
    }
}
