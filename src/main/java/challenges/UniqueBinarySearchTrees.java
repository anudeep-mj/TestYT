package challenges;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    /*
    Say we have a function G(n) which means the total num of bst that you can create with n nodes.
    now G(n) = F(1,n) + F(2, n)... + F(n, n) where F is the function which says the nums of bst created with a node as the root among n
    Now, F(m, n) = F(m-1, n) * F(m, n-1) => G(m-1) * G(n-m) basically means when you have one node as the root,
    the total num of unique bst it can form is the cartesian prod of its left and right child nodes.
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        //you can create one type of tree with 0 or 1 nodes. Empty or just root
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] = G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}
