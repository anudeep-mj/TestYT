package challenges;
/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */

import utils.TreeNode;

public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getDiameterRecursively(root);
    }

    int getDiameterRecursively(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = getDiameterRecursively(root.getLeft());
        int R = getDiameterRecursively(root.getRight());
        max = Math.max(max, L + R);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {

    }

}
