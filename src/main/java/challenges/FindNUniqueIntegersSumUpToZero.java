package challenges;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 * Example 1:
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 *
 * Example 2:
 * Input: n = 3
 * Output: [-1,0,1]
 *
 * Example 3:
 * Input: n = 1
 * Output: [0]
 */
public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];

        int mid = n/2;

        for(int i = 0; i < mid; i++) {
            result[i] = i+1;
        }

        int left = 0;
        if(n % 2 != 0) {
            mid = mid+1;
        }
        for(int i = mid; i < n; i++) {
            result[i] = -1 * result[left++];
        }

        return result;
    }
}
