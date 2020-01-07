package challenges;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTreeTraversal {
    public static List<Integer> treeByLevels(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        levelOrderTraversal(node, result);
        return result;
    }

    private static void levelOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).push(node);

        while (!queue.isEmpty()){
            TreeNode poppedNode = queue.poll();
            result.add(poppedNode.getVal());

            if (poppedNode.getLeft() != null) {
                queue.offer(poppedNode.getLeft());
            }
            if (poppedNode.getRight() != null) {
                queue.offer(poppedNode.getRight());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(-22));
        root.setRight(new TreeNode(11));

        root.getLeft().setLeft(new TreeNode(9));
        root.getLeft().setRight(new TreeNode(50));

        root.getRight().setLeft(new TreeNode(9));
        root.getRight().setRight(new TreeNode(2));


        treeByLevels(root);
    }
}
