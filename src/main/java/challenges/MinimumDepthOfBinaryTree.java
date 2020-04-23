package challenges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        //lets use bfs. basically means lets use a queue to store the data per level and add iccrement level. when you get a node with no left and right, return level.
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int level = 1;
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while (size > 0) {
                TreeNode node = bfsQueue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    bfsQueue.add(node.left);
                }
                if (node.right != null) {
                    bfsQueue.add(node.right);
                }
                size--;
            }
            level++;
        }
        return level;
    }
}
