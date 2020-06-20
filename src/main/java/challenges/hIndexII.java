package challenges;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 * Example:
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * Note:
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * Follow up:
 * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 */
public class hIndexII
{
    public int hIndex (int[] citations)
    {
        if (citations.length == 0) {
            return 0;
        }

        int left = 0;
        int right = citations.length - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            // System.out.println("left:" + left);
            // System.out.println("right:" + right);

            System.out.println("mid:" + mid);
            //should have thought of this...
            if (citations[mid] == (citations.length - mid)) {
                return citations[mid];
            }

            //System.out.println("citations.length - mid: " + (citations.length - mid));

            if (citations[mid] > citations.length - mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return citations.length - (right + 1);
    }

    //not a good soln
    public static int hIndexIE (int[] citations)
    {
        if (citations.length == 0) {
            return 0;
        }

        int prevR = 1;
        int res = 0;
        int n = 1;
        int m = Integer.MAX_VALUE;

        for (int idx = citations.length - 1; idx >= 0; idx--) {
            if (citations[idx] == 0) {
                continue;
            }

            m = Math.min(m, citations[idx]);

            if (n < m) {
                res = n;
            }
            else {
                res = m;
            }

            if (prevR > res) {
                return prevR;
            }

            prevR = res;
            n++;
        }

        return res;
    }

    public static void main (String[] args)
    {
        hIndexIE(new int[] { 0, 0 });
    }
}
