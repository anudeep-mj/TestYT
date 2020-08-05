package challenges;
/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node. The answer can be returned in any order.
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * Output: [7,4,1]
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree
{
    Map<TreeNode, List<TreeNode>> nodeMap = new HashMap<>();

    public List<Integer> distanceK (TreeNode root, TreeNode target, int K)
    {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        buildBidirectionalMapFromTree(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        int tempK = 0;
        Set<TreeNode> seenSet = new HashSet<>();

        while (!q.isEmpty()) {
            if (K == tempK) {
                while (!q.isEmpty()) {
                    result.add(q.poll().val);
                }
                return result;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                seenSet.add(node);
                List<TreeNode> nodeList = nodeMap.get(node);

                for (TreeNode t : nodeList) {
                    if (!seenSet.contains(t)) {
                        q.offer(t);
                    }
                }
            }

            tempK++;
        }

        return result;
    }

    private void buildBidirectionalMapFromTree (TreeNode node, TreeNode parent)
    {
        if (node == null) {
            return;
        }

        if (!nodeMap.containsKey(node)) {
            nodeMap.put(node, new ArrayList<>());
            if (parent != null) {
                nodeMap.get(node).add(parent);
                nodeMap.get(parent).add(node);
            }
            buildBidirectionalMapFromTree(node.left, node);
            buildBidirectionalMapFromTree(node.right, node);
        }
    }

}
