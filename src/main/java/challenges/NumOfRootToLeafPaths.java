package challenges;

public class NumOfRootToLeafPaths {

    Integer result = 0;

    public int rootToLeafPaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        rootToLeafPathsRec(root);
        return result;
    }

    private void rootToLeafPathsRec(TreeNode node) {
        if (node.left == null && node.right == null) {
            result++;
            return;
        }

        if (node.left != null) {
            rootToLeafPathsRec(node.left);
        }

        if (node.right != null) {
            rootToLeafPathsRec(node.right);
        }
    }
}
