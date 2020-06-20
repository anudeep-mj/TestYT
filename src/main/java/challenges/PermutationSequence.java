package challenges;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * <p>
 * Given n and k, return the kth permutation sequence.
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * <p>
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * <p>
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        return "";
    }


    /**
     * Inefficient soln which uses the principle of backtracking for generating all permuations for a given string
     * O(n * n!) since we touch n! permutations where n is the length of the string and worst case means k is the last permutation
     */
    int count = 0;
    String result = "";

    public String getPermutationInefficient(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        String ns = sb.toString();
        count = k;

        try {
            permutationsHelper("", ns);
        } catch (Exception fe) {
            return result;
        }

        return result;
    }

    private void permutationsHelper(String prefix, String s) throws Exception {
        //System.out.println("prefix:" + prefix + " s:" + s);
        if (s.length() == 0) {
            count--;
            if (count == 0) {
                result = prefix;
                throw new Exception();
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            permutationsHelper(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
        }
    }
}
