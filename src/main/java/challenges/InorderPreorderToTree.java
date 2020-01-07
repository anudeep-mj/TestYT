package challenges;

import utils.TreeNode;

public class InorderPreorderToTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0, inorder.length-1, preorder, inorder);
    }

    private TreeNode helper(int preOrderStart, int inorderStart, int inorderEnd , int[] preorder, int[] inorder) {
        if (preOrderStart > preorder.length -1 || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrderStart]);
        int inorderIdx = 0;
        for (int idx = inorderStart; idx<inorderEnd; idx++) {
            if (inorder[idx] == root.getVal()) {
                inorderIdx = inorder[idx];
            }
        }

        int numOfNodesOnLeftToRoot = inorderIdx - inorderStart;

        root.setLeft(helper(preOrderStart + 1, inorderStart, inorderIdx-1, preorder, inorder));
        root.setRight(helper(preOrderStart + numOfNodesOnLeftToRoot + 1, inorderIdx+1, inorderEnd, preorder, inorder));
        return root;
    }
}
