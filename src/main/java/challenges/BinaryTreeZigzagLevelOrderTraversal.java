package challenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal
{
    public List<List<Integer>> zigzagLevelOrder (TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        boolean leftToRight = false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        /*
        Mistake done: rather than worry about the way you add to the q, manipulate the way you add to the list itself.
        */
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (leftToRight) {
                    levelList.add(node.val);
                }
                else {
                    levelList.addFirst(node.val);
                }

                //System.out.println("popped node: " + node.val);
                if (node.right != null) {
                    //System.out.println("q.offer.right: " + node.right.val);
                    q.offer(node.right);
                }
                if (node.left != null) {
                    //System.out.println("q.offer.left: " + node.left.val);
                    q.offer(node.left);
                }
            }
            result.add(levelList);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
