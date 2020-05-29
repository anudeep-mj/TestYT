package challenges;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * Follow up:
 *
 *     It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 *     Space complexity should be O(n).
 *     Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {
    public void countBitsEfficient(int num) {
        //https://leetcode.com/problems/counting-bits/discuss/656566/JAVA-C%2B%2B-3-liner-or-Detailed-Explanation-or-100-faster
    }

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            String binaryString = Integer.toBinaryString(i);
            int numberOf1s = getNumberOfOnesInBinString(binaryString);
            result[i] = numberOf1s;
        }
        return result;
    }

    private int getNumberOfOnesInBinString (String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        countingBits.countBits(5);
    }
}
