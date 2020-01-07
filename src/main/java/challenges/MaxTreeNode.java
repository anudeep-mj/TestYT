package challenges;

import utils.TreeNode;

import java.util.Stack;

public class MaxTreeNode {
    static int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode popped = stack.pop();
            if (popped.getVal() > maxValue) {
                maxValue = popped.getVal();
            }
            if (popped.getLeft() != null) {
                stack.push(popped.getLeft());
            }
            if (popped.getRight() != null) {
                stack.push(popped.getRight());
            }
        }

        return maxValue;
    }
}
