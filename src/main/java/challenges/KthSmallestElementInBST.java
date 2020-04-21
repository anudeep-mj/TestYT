package challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderTraversal = new ArrayList<>();
        inorderTraversal(root, inorderTraversal);
        return inorderTraversal.get(k-1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> inorderTraversal) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, inorderTraversal);
        inorderTraversal.add(root.val);
        inorderTraversal(root.right, inorderTraversal);
    }
}
