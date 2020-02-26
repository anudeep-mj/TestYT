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
        if (val < lower) {
            return false;
        }
        if (val > upper) {
            return false;
        }

        if (!validateBSTRecursive(root.getLeft(), val, upper)) return false;
        if (!validateBSTRecursive(root.getRight(), lower, val)) return false;
        return true;
    }
}
