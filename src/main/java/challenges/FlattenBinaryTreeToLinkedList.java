package challenges;

public class FlattenBinaryTreeToLinkedList {
    TreeNode prev = new TreeNode(-1);

    public void flatten(TreeNode root) {
        dfsRecursive(root);
    }

    private void dfsRecursive(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        if (node.left != null) {
            dfsRecursive(node.left);
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;

            // forgot to use a separate node here
            TreeNode curr = node.right;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = temp;
        }

        if (node.right != null) {
            dfsRecursive(node.right);
        }
    }
}
