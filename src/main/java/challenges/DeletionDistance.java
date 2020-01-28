package challenges;

/**
 * The deletion distance of two strings is the minimum number of characters you need to delete in the two strings
 * in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:
 *
 *     By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 *     We cannot get the same string from both strings by deleting 2 letters or fewer.
 *
 * Examples:
 *
 * input:  str1 = "dog", str2 = "frog"
 * output: 3
 *
 * input:  str1 = "some", str2 = "some"
 * output: 0
 *
 * input:  str1 = "some", str2 = "thing"
 * output: 9
 *
 * input:  str1 = "", str2 = ""
 * output: 0
 */
public class DeletionDistance {

    static int deletionDistance(String str1, String str2) {
        int s1Len = str1.length();
        int s2Len = str2.length();
        int[][] memo = new int[s1Len + 1][s2Len + 1];

        for (int i = 0; i<= s1Len; i++) {
            for (int j = 0; j<= s2Len; j++) {
                if (i == 0) {
                    memo[i][j] = j;
                }
                else if (j == 0) {
                    memo[i][j] = i;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1];
                } else {
                    memo[i][j] = Math.min(memo[i-1][j], memo[i][j-1]) + 1;
                }
            }
        }
        return memo[s1Len][s2Len];
    }
    public static void main(String[] args) {
        deletionDistance("some", "thing");
    }
}
