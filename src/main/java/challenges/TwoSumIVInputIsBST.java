package challenges;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsBST
{
    /*
    Another way is just to get inorder traversal and do a two pointer search on the array with i<j condition
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTargetHelper(root, k, set);
    }

    private boolean findTargetHelper(TreeNode node, int k, Set<Integer> set) {
        if(node == null) {
            return false;
        }

        if(set.contains(k - node.val)) {
            return true;
        }

        set.add(node.val);

        boolean foundLeft = findTargetHelper(node.left, k, set);
        boolean foundRight = findTargetHelper(node.right, k, set);

        return foundLeft || foundRight;
    }
}
