package challenges;

import java.util.Arrays;

public class ConstructBSTFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = preorder;
        Arrays.sort(inorder);

        return helper(0, 0, inorder.length-1, inorder, preorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] inorder, int[] preorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);

        int inorderIdx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inorderIdx = i;
            }
        }

        root.left = helper(preStart + 1, inStart, inorderIdx - 1, inorder, preorder);
        root.right = helper(preStart + inorderIdx - inStart + 1, inorderIdx + 1, inEnd, inorder, preorder);

        return root;
    }
}
