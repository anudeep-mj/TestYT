package challenges;
/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */

import utils.TreeNode;

public class ValidateBinarySearchTree {
    public boolean validateBST(TreeNode root) {
        return validateBSTRecursive(root, null, null);
    }

    private boolean validateBSTRecursive(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        int val = root.getVal();
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!validateBSTRecursive(root.getLeft(), lower, val)) return false;
        if (!validateBSTRecursive(root.getRight(), val, upper)) return false;
        return true;
    }

    /**
     * 2nd time
     */
    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);
    }

    private boolean validBST(TreeNode node, Integer upperLimit, Integer lowerLimit) {
        if(node == null) {
            return true;
        }

        //upperLimit is not null when it is in the left side of the tree.
        if(upperLimit != null && node.getVal() >= upperLimit) {
            return false;
        }

        //lowerLimit is not null when it is in the right side of the tree
        if(lowerLimit != null && node.getVal() <= lowerLimit) {
            return false;
        }

        boolean left =  validBST(node.getLeft(), node.getVal(), lowerLimit);
        boolean right = validBST(node.getRight(), upperLimit, node.getVal());

        return left && right;
    }
}
