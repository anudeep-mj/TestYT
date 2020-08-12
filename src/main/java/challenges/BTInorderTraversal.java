package challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Traverse binary tree in inorder traversal and print nodes.
 */
public class BTInorderTraversal
{

    public void printInorder (TreeNode root)
    {
        inorderTraversalHelper(root);
    }

    private void inorderTraversalHelper (TreeNode node)
    {
        if (node == null) {
            return;
        }

        inorderTraversalHelper(node.left);
        System.out.println(node.val);
        inorderTraversalHelper(node.right);
    }

    private List<Integer> inorderTraversalIterative (TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
