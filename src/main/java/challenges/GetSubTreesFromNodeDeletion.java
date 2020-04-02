package challenges;
/*
        1
    2       3
  4       5   6

input: [2, 5]

output: [4, 1]
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class GetSubTreesFromNodeDeletion {

    public static List<Integer> getSubTreeRoots(TreeNode root, List<Integer> nodeValsToRemove) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        if (!nodeValsToRemove.contains(root.val)) {
            result.add(root.val);
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (nodeValsToRemove.contains(node.val)) {

                int index = result.indexOf(node.val);
                if (index != -1) {
                    result.remove(result.indexOf(node.val));
                }

                if (node.left != null) {
                    result.add(node.left.val);
                }
                if (node.right != null) {
                    result.add(node.right.val);
                }
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        List<Integer> result = getSubTreeRoots(root, Arrays.asList(5, 6));
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
















