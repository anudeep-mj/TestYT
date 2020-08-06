package challenges;
/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * Example:
 * Given a binary tree
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * <p>
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */

import utils.TreeNode;

public class DiameterOfBinaryTree {
    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getDiameterRecursively(root);
    }

    static int getDiameterRecursively(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = getDiameterRecursively(root.getLeft());
        int R = getDiameterRecursively(root.getRight());
        max = Math.max(max, L + R);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(3));
        root.setLeft(new TreeNode(2));
        root.getRight().setRight(new TreeNode(5));
        root.getLeft().setLeft(new TreeNode(4));
        diameterOfBinaryTree(root);
    }

}
