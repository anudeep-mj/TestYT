package challenges;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 */
//https://leetcode.com/problems/number-complement/discuss/96018/Java-very-simple-code-and-self-evident-explanation
public class NumberComplement {
    public int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }
}
