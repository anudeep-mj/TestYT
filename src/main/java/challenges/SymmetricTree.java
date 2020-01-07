package challenges;

import utils.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.getVal() == node2.getVal()) &&
                isMirror(node1.getLeft(), node2.getRight()) &&
                isMirror(node1.getRight(), node2.getLeft());
    }
}
