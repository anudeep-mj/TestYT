package challenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 *
 * Example 2:
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 */
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            ArrayList<Integer> levelList = new ArrayList<>();
            int qsize =  q.size();
            boolean xExists = false;
            boolean yExists = false;

            for(int i = 0; i < qsize; i++) {
                TreeNode poppedNode = q.poll();
                if (poppedNode.val == x) {
                    xExists = true;
                }
                if (poppedNode.val == y) {
                    yExists = true;
                }
                //System.out.println("q.poll " + poppedNode);
                if(poppedNode.left != null && poppedNode.right != null) {
                    if(poppedNode.left.val == x && poppedNode.right.val == y) {
                        return false;
                    }
                    if(poppedNode.left.val == y && poppedNode.right.val == x) {
                        return false;
                    }
                }

                if(poppedNode.left != null) {
                    q.offer(poppedNode.left);
                }

                if(poppedNode.right != null) {
                    q.offer(poppedNode.right);
                }
            }

            if(xExists && yExists) {
                return true;
            }
        }
        return false;
    }

    public void listprinter(ArrayList arrayList) {
        for (Object o : arrayList) {
            System.out.print(o + " ");
        }
        System.out.println("");
    }
}
