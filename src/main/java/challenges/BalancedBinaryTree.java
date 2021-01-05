package challenges;

import javafx.util.Pair;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 *     a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 * Input: root = []
 * Output: true
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [0, 5000].
 *     -104 <= Node.val <= 104
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).getKey();
    }

    private Pair<Boolean, Integer> isBalancedHelper(TreeNode node) {
        if (node == null) {
            return new Pair<>(true, -1);
        }

        Pair<Boolean, Integer> left = isBalancedHelper(node.left);
        Pair<Boolean, Integer> right = isBalancedHelper(node.right);

        if (!left.getKey()) {
            return new Pair<>(false, -1);
        }

        if (!right.getKey()) {
            return new Pair<>(false, -1);
        }

        if (Math.abs(left.getValue() - right.getValue()) > 1) {
            return new Pair<>(false, -1);
        } else {
            int height = Math.max(left.getValue(), right.getValue()) + 1;
            return new Pair<>(true, height);
        }
    }
}
