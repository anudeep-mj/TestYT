package challenges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeDeserializeBinarySearchTree
{
    // Encodes a tree to a single string.
    public String serialize (TreeNode root)
    {
        StringBuilder serializedTree = new StringBuilder();
        if (root == null) {
            return serializedTree.toString();
        }

        serializedBSTHelper(root, serializedTree);
        //System.out.println(serializedTree.toString());
        return serializedTree.toString();
    }

    private void serializedBSTHelper (TreeNode node, StringBuilder serializedTree)
    {
        if (node == null) {
            return;
        }

        serializedTree.append(node.val);
        serializedTree.append(",");

        serializedBSTHelper(node.left, serializedTree);
        serializedBSTHelper(node.right, serializedTree);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize (String data)
    {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] dataArr = data.split(",");
        Queue<String> dq = new LinkedList<>(Arrays.asList(dataArr));

        return deserializeHelper(dq, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeHelper (Queue<String> dq, int lowerbound, int upperbound)
    {
        if (dq.isEmpty()) {
            return null;
        }
        int data = Integer.valueOf(dq.peek());
        if (data > upperbound || data < lowerbound) {
            return null;
        }

        data = Integer.valueOf(dq.poll());

        //System.out.println(data);

        TreeNode node = new TreeNode(data);
        node.left = deserializeHelper(dq, lowerbound, data);
        node.right = deserializeHelper(dq, data, upperbound);

        return node;
    }
}
