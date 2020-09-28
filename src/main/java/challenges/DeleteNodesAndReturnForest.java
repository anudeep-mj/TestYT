package challenges;

import java.util.*;

/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 */
public class DeleteNodesAndReturnForest
{

    public List<TreeNode> delNodesRecursive (TreeNode root, int[] to_delete)
    {
        if (root == null) {
            return new ArrayList<>();
        }

        HashSet<Integer> hashSetToDelete = new HashSet<>();
        for (int i : to_delete) {
            hashSetToDelete.add(i);
        }

        ArrayList<TreeNode> result = new ArrayList<>();

        delNodesRecursiveHelper(root, hashSetToDelete, result, true);
        return result;
    }

    private TreeNode delNodesRecursiveHelper (
        TreeNode node,
        HashSet<Integer> hashSetToDelete,
        ArrayList<TreeNode> result,
        boolean isRoot)
    {
        if (node == null) {
            return null;
        }

        boolean toBeDeleted = hashSetToDelete.contains(node.val);

        if (isRoot && !toBeDeleted) {
            result.add(node);
        }

        node.left = delNodesRecursiveHelper(node.left, hashSetToDelete, result, toBeDeleted);
        node.right = delNodesRecursiveHelper(node.right, hashSetToDelete, result, toBeDeleted);

        return toBeDeleted ? null : node;
    }

    public List<TreeNode> delNodes (TreeNode root, int[] to_delete)
    {
        if (root == null) {
            return new ArrayList<>();
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i : to_delete) {
            hs.add(i);
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        HashSet<TreeNode> result = new HashSet<>();
        result.add(root);
        if (hs.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
        }

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }

            // System.out.println("node:" + node.val);
            // System.out.println("q:" + q);
            //System.out.println("to remove hs:" + hs);

            if (node.left != null && hs.contains(node.left.val)) {
                //System.out.println("herrr1");
                if (node.left.left != null) {
                    result.add(node.left.left);
                }
                if (node.left.right != null) {
                    result.add(node.left.right);
                }
                node.left = null;
            }

            //System.out.println("result1:" + result);

            if (node.right != null && hs.contains(node.right.val)) {
                //System.out.println("heerr2");

                if (node.right.left != null) {
                    result.add(node.right.left);
                }
                if (node.right.right != null) {
                    result.add(node.right.right);
                }
                node.right = null;
            }

            // if(node.val == 3) {
            //     System.out.println("hs.contains(node.val):" + hs.contains(node.val));
            //     System.out.println("result.contains(node.val):" + result.contains(node));
            // }

            if (hs.contains(node.val) && result.contains(node)) {
                //System.out.println("herrr3");
                result.remove(node);
            }

            //System.out.println("result final:" + result);
        }

        List<TreeNode> mainList = new ArrayList<TreeNode>();
        mainList.addAll(result);
        return mainList;
    }

    /*
    Second try
     */

    List<TreeNode> result;

    public List<TreeNode> delNodes2 (TreeNode root, int[] to_delete)
    {
        result = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i : to_delete) {
            hs.add(i);
        }
        del(root, hs);

        if (hs.contains(root.val)) {
            return result;
        }
        else {
            result.add(root);
            return result;
        }
    }

    private TreeNode del (TreeNode node, HashSet<Integer> delSet)
    {
        if (node == null) {
            return null;
        }

        node.left = del(node.left, delSet);
        node.right = del(node.right, delSet);

        if (delSet.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
            return null;
        }

        return node;
    }
}
