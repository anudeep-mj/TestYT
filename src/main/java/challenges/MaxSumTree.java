package challenges;

import lombok.extern.java.Log;
import utils.TreeNode;

@Log
public class MaxSumTree {
    static int maxSumValue = 0;

    static int maxSum(TreeNode root) {
        maxSumValue = 0;
        helper(root, 0);
        return maxSumValue;
    }

    private static void helper(TreeNode node, int value) {
        //System.out.println(node.getVal());
        if (node == null) {
            return;
        }
        int sum = node.getVal() + value;

        if (node.getLeft() == null && node.getRight() == null) {
            System.out.println("old sum: " + sum);
            System.out.println("old maxSumValue: " + maxSumValue);
            if (sum > maxSumValue) {
                maxSumValue = sum;
            }
        }
        helper(node.getLeft(), sum);
        helper(node.getRight(), sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.setRight(new TreeNode(11));
        root.setLeft(new TreeNode(-22));

        root.getRight().setLeft(new TreeNode(9));
        root.getRight().setRight(new TreeNode(2));

        root.getLeft().setLeft(new TreeNode(9));
        root.getLeft().setRight(new TreeNode(50));

        maxSum(root);
    }
}
