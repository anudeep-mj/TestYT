package challenges;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *     Search for a node to remove.
 *     If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class DeleteNodeInBST
{
    public TreeNode deleteNode (TreeNode root, int key)
    {
        if (root == null) {
            return null;
        }

        return delNodeRec(root, key);
    }

    private TreeNode delNodeRec (TreeNode node, int key)
    {
        if (node == null) {
            return null;
        }

        if (node.val < key) {
            node.right = delNodeRec(node.right, key);
        }
        else if (node.val > key) {
            node.left = delNodeRec(node.left, key);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            TreeNode minNode = getMinNode(node.right);
            node.val = minNode.val;
            node.right = delNodeRec(node.right, minNode.val);
        }

        return node;
    }

    private TreeNode getMinNode (TreeNode node)
    {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
