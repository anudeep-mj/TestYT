package challenges;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * For example, given the array [17, 0, -4, 3, 15] you should create the following tree:
 *
 *     17
 *    /  \
 *   0   -4
 *  / \
 * 3   15
 */

public class ArrayToTree {
    static TreeNode arrayToTree(int[] array) {
        if (array.length == 0) {
            return null;
        }

        int length = array.length;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);

        queue.offer(root);

        int idx = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            int leftIdx = 2 * idx + 1;
            int rightIdx = 2 * idx + 2;
            if (leftIdx < length) {
                node.setLeft(new TreeNode(array[leftIdx]));
                queue.offer(node.getLeft());
            } else {
                node.setLeft(null);
            }

            if (rightIdx < length) {
                node.setRight(new TreeNode(array[rightIdx]));
                queue.offer(node.getRight());
            } else {
                node.setRight(null);
            }

            idx++;
        }

        return root;
    }

    public static void main(String[] args) {
        arrayToTree(arrayFrom(17, 0, -4, 3, 15));
    }

    static private int[] arrayFrom(int ... values) {
        return values;
    }
}
