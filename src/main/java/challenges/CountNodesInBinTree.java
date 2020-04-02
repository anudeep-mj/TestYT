package challenges;

//Given a complete binary tree, count the number of nodes.


//note. if you want to do 2^k - 1. you can do it as: (2<<k) - 1.
import utils.TreeNode;

public class CountNodesInBinTree {
    public int heightOfTree(TreeNode root) {
        if(root == null) {
            //this depends on your understanding of what the height is for single root.
            return -1;
        }
        return heightOfTree(root.getLeft()) + 1;
    }

    public int countNodes(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int lh = heightOfTree(root.getLeft());
        int rh = heightOfTree(root.getRight());

        if(lh == rh) {
            return (2 << lh) - 1;
        } else {
            return countNodes(root.getLeft()) + countNodes(root.getRight());
        }
    }

    public static void main(String[] args) {

    }
}
