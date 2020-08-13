package challenges;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *     The number of elements initialized in nums1 and nums2 are m and n respectively.
 *     You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 *
 * Constraints:
 *     -10^9 <= nums1[i], nums2[i] <= 10^9
 *     nums1.length == m + n
 *     nums2.length == n
 */
public class MergeSortedArrays
{
    //nums1 = [1,4,7,0,0,0], m = 3
    //nums2 = [3,5,6],       n = 3
    public void merge (int[] nums1, int m, int[] nums2, int n)
    {
        int i = m - 1;
        int j = n - 1;
        int endPtr = m + n - 1;

        if (nums1.length == 0) {
            return;
        }
        if (nums2.length == 0) {
            return;
        }

        while (i >= 0 && j >= 0) {
            //System.out.println("aaaaa");
            if (nums1[i] > nums2[j]) {
                nums1[endPtr--] = nums1[i];
                i--;
            }
            else {
                nums1[endPtr--] = nums2[j];
                j--;
            }
        }

        while (j >= 0) {
            nums1[endPtr--] = nums2[j--];
        }
    }
}
