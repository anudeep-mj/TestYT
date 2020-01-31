package challenges;

import utils.TreeNode;

public class BTLongestConsecutiveSeq {
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        dfsRecursive(root, null, 0);
        return maxLen;
    }

    public void dfsRecursive(TreeNode node, TreeNode parent, int tempLen) {
        if(node == null) {
            return;
        }
        if(parent != null && node.getVal() == parent.getVal() + 1) {
            tempLen++;
        } else {
            tempLen = 1;
        }
        maxLen = Math.max(tempLen, maxLen);
        dfsRecursive(node.getLeft(), node, tempLen);
        dfsRecursive(node.getRight(), node, tempLen);
    }

    public static void main(String[] args) {

    }

}
