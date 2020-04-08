package challenges;

public class HeightOfBinaryTree {
    public int heightOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return heightRecursive(root);
    }

    private int heightRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHt = heightRecursive(root.left);
        int rightHt = heightRecursive(root.right);

        return 1 + Math.max(leftHt, rightHt);
    }
}
