package challenges;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        bfsHelper(root);
        return result;
    }

    private void bfsHelper(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                TreeNode node = q.poll();
                list.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            //a better idea is to push to the result list using 0 index such as result.add(0, list);
            stack.push(list);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
