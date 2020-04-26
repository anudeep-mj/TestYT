package challenges;

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
}
