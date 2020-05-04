package challenges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 * You may serialize the following tree:
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as BFS: "[1,2,3,null,null,4,5]"
 * as DFS: "[1,2,null,null,3,4,5]"
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelperBFS(root);
    }

    private String serializeHelperBFS(TreeNode node) {
        if (node == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode popped = queue.poll();
            if (popped != null) {
                queue.add(popped.left);
                queue.add(popped.right);
            }

            if (popped != null) {
                stringBuilder.append(popped.val + ",");
            } else {
                stringBuilder.append("null,");
            }
        }

        return stringBuilder.toString().substring(0, stringBuilder.length()-1);
    }

    private String serializeHelperDFS(TreeNode node) {
        if (node == null) {
            return "null";
        }

        String left = serializeHelperDFS(node.left);
        String right = serializeHelperDFS(node.right);

        return node.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree from bfs serialize
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(nodes));
        deserializeHelperFromDFS(queue);

//        Stack<String> stringStack = new Stack<>();
//        stringStack.addAll(Arrays.asList(nodes));
//        deserializeHelperFromBFS(stringStack);

        return null;
    }

    private TreeNode deserializeHelperFromDFS(Queue<String> data) {
        String popped = data.poll();
        if (popped.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(popped));
        node.left = deserializeHelperFromDFS(data);
        node.right = deserializeHelperFromDFS(data);

        return node;
    }

}
