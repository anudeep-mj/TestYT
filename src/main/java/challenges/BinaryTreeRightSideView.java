package challenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * Example:
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return rightSideViewHelper(root);
    }

    private List<Integer> rightSideViewHelper(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        ArrayList<ArrayList<Integer>> cache = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int qsize = q.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < qsize; i++) {
                TreeNode node = q.poll();
                levelList.add(node.val);
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }

                //better have a variable temp which keeps on updating to node. (we need to do left first and then right in that case to get the right most)
            }
            cache.add(levelList);
        }

        for (List<Integer> list : cache) {
            result.add(list.get(0));
        }
        return result;
    }
}
