package challenges;

import utils.NaryNode;

public class DiameterOfNaryTree {
    public int NaryTreeDiameter(NaryNode root) {
        if (root == null) {
            return 0;
        }
        return NaryHelper(root);
    }

    public int NaryHelper(NaryNode node) {
        if (node == null) {
            return 0;
        }
        int cur = 0;
        for (NaryNode child : node.getChildren()) {
            cur = Math.max(cur, NaryHelper(child));
        }
        return cur + 1;
    }

    public static void main(String[] args) {

    }
}
