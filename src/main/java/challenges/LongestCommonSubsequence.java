package challenges;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted
 * without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {
    public static int largestCommonSubsequence(String input1, String input2) {
        int input1Sz = input1.length();
        int input2Sz = input2.length();

        int[][] mat = new int[input1Sz + 1][input2Sz + 1];
        for (int i = 1; i <= input1Sz; i++) {
            for (int j = 1; j <= input2Sz; j++) {
                if (input1.charAt(i-1) == input2.charAt(j-1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat[input1Sz][input2Sz];
    }

    public static void main(String[] args) {
        largestCommonSubsequence("abcde", "ace");
    }

}
