package challenges;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level
 * are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * Output: 6
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = leftDepth(root.left);
        int rightDepth = rightDepth(root.right);

        if (leftDepth == rightDepth) {
            return (1 << leftDepth + 1) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }

        return depth;
    }

    private int rightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.right;
            depth++;
        }

        return depth;
    }
}
