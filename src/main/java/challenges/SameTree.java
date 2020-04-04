package challenges;

import utils.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.getVal() != q.getVal()) {
            return false;
        }

        return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
    }
}
