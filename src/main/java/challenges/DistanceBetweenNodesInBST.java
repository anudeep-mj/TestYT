package challenges;

/**
 * Given a list of unique integers nums, construct a BST from it (you need to insert nodes one-by-one
 * with the given order to get the BST) and find the distance between two nodes node1 and node2.
 * Distance is the number of edges between two nodes.
 * If any of the given nodes does not appear in the BST, return -1.
 *
 * Example 1:
 *
 * Input: nums = [2, 1, 3], node1 = 1, node2 = 3
 * Output: 2
 * Explanation:
 *      2
 *    /   \
 *   1     3
 */
public class DistanceBetweenNodesInBST
{
    //The idea is to first create a BST. Next find LCA of the two nodes. Next get distance of each node from the LCA and add it to return the result.
    public int bstDistance (int[] nums, int node1, int node2)
    {
        TreeNode root = buildBST(nums, node1, node2);
        if (root == null)
            return -1;
        TreeNode lca = getLCA(root, node1, node2);
        return distanceFromLCA(lca, node1) + distanceFromLCA(lca, node2);
    }

    private int distanceFromLCA (TreeNode src, int destNodeVal)
    {
        if (src.val == destNodeVal) {
            return 0;
        }

        if (src.val > destNodeVal) {
            src = src.left;
        }
        else {
            src = src.right;
        }

        return 1 + distanceFromLCA(src, destNodeVal);
    }

    //LCA of BST is a bit diff compared to the reg lca of binary tree here.. a lot simpler
    private TreeNode getLCA (TreeNode root, int node1, int node2)
    {
        while (true) {
            if (root.val > node1 && root.val > node2) {
                root = root.right;
            }
            else if (root.val < node1 && root.val < node2) {
                root = root.left;
            }
            else {
                return root;
            }
        }
    }

    private TreeNode buildBST (int[] nums, int node1, int node2)
    {
        TreeNode root = null;
        boolean found1 = false;
        boolean found2 = false;

        for (int num : nums) {
            if (num == node1)
                found1 = true;
            if (num == node2)
                found2 = true;
            TreeNode node = new TreeNode(num);
            if (root == null) {
                root = node;
                continue;
            }
            addToBST(root, node);
        }

        if (!found1 || !found2)
            return null;
        return root;
    }

    private void addToBST (TreeNode root, TreeNode node)
    {
        for (TreeNode curr = root; true; ) {
            if (curr.val > node.val) {
                if (curr.left == null) {
                    curr.left = node;
                }
                else {
                    curr = curr.left;
                    continue;
                }
            }
            else {
                if (curr.right == null) {
                    curr.right = node;
                }
                else {
                    curr = curr.right;
                    continue;
                }
            }
        }
    }
}
