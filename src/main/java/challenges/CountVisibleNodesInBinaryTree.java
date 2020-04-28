package challenges;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * In a binary tree, if in the path from root to the node A, there is no node with greater value than A’s, this node A is visible.
 * We need to count the number of visible nodes in a binary tree.
 *
 * Example 1:
 * Input:
 *         5
 *      /     \
 *    3        10
 *   /  \     /
 * 20   21   1
 *
 * Output: 4
 * Explanation: There are 4 visible nodes: 5, 20, 21, and 10.
 *
 * Example 2:
 * Input:
 *   -10
 * 	\
 * 	-15
 * 	   \
 * 	   -1
 *
 * Output: 2
 * Explanation: Visible nodes are -10 and -1.
 */
public class CountVisibleNodesInBinaryTree {

    public List<TreeNode> getVisibleList(TreeNode root) {
        List<TreeNode> visibleList = new ArrayList<>();
        return getVisibleListHelper(root, 0, visibleList);
    }

    private List<TreeNode> getVisibleListHelper(TreeNode node, int maxValue, List<TreeNode> visibleList) {
        if (node == null) {
            return null;
        }

        if (node.val > maxValue) {
            maxValue = node.val;
            visibleList.add(node);
        }

        getVisibleListHelper(node.left, maxValue, visibleList);
        getVisibleListHelper(node.right, maxValue, visibleList);

        return visibleList;
    }
}
