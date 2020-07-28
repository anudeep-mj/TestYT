package challenges;

/**
 * Given an increasing sequence a[], we need to find the K-th missing contiguous element in the increasing sequence
 * which is not present in the sequence. If no k-th missing element is there output -1.
 *
 * Examples :
 * Input : a[] = {2, 3, 5, 9, 10};
 *         k = 1;
 * Output : 4
 * Explanation: Missing Element in the increasing
 * sequence are {4, 6, 7, 8}. So k-th missing element
 * is 4
 *
 * Input : a[] = {2, 3, 5, 9, 10, 11, 12};
 *         k = 4;
 * Output : 8
 * Explanation: missing element in the increasing
 * sequence are {4, 6, 7, 8}  so k-th missing
 * element is 8
 */
public class KthMissingElementInSortedArray {
    static int missingK(int[] a, int k) {
        if(k <= 0) {
            return -1;
        }

        int size = a.length;
        if(size <= 1) {
            return -1;
        }

        int result = -1;
        int left = 0;
        int right = 1;

        while (k > 0 && right < a.length) {
            int eLeft = a[left++];
            int eRight = a[right++];

            if(eRight - eLeft > 1) {
                for (int i = eLeft+1; i < eRight; i++) {
                    k--;
                    if(k == 0) {
                        result = i;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        missingK(new int[]{2,3,5,9,10,11,12}, 4);
    }
}
