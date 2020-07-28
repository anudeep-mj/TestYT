package challenges;

/**
 * Traverse binary tree in inorder traversal and print nodes.
 */
public class BTInorderTraversal {

    public void printInorder(TreeNode root) {
        inorderTraversalHelper(root);
    }

    private void inorderTraversalHelper(TreeNode node) {
        if(node == null) {
            return;
        }

        inorderTraversalHelper(node.left);
        System.out.println(node.val);
        inorderTraversalHelper(node.right);
    }
}
