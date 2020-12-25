package challenges;

/**
 * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n
 * and is greater in value than n. If no such positive integer exists, return -1.
 * <p>
 * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does
 * not fit in 32-bit integer, return -1.
 * <p>
 * Example 1:
 * Input: n = 12
 * Output: 21
 * <p>
 * Example 2:
 * Input: n = 21
 * Output: -1
 * <p>
 * Constraints:
 * 1 <= n <= 231 - 1
 */
public class NextGreaterElementIII {
    public static int nextGreaterElement(int n) {
        if (n < 12) {
            return -1;
        }

        char[] carray = String.valueOf(n).toCharArray();

        //first find the number in the array which is smaller than the one in the right when traversing from right to left
        int idx = carray.length - 1;

        while (idx > 0) {
            if (carray[idx - 1] < carray[idx]) {
                break;
            }
            idx--;
        }

        //System.out.println("idx:" + idx);

        if (idx == 0) {
            return -1;
        }

        int x = Character.getNumericValue(carray[idx - 1]);

        //find a number on the right side of x which is greater than x but the smallest among them
        int temp = Integer.MAX_VALUE;
        int nxtLargeIdx = 0;
        for (int i = idx; i < carray.length; i++) {
            if (Character.getNumericValue(carray[i]) > x && Character.getNumericValue(carray[i]) <= temp) {
                temp = Character.getNumericValue(carray[i]);
                nxtLargeIdx = i;
            }
        }

        //System.out.println("nxtLargeIdx:" + nxtLargeIdx);
        //System.out.println("temp:" + temp);


        //swap idx and nxtLargeIdx
        char tmp = 'g';
        tmp = carray[idx - 1];
        carray[idx - 1] = carray[nxtLargeIdx];
        carray[nxtLargeIdx] = tmp;

        //System.out.println("carray:" + new String(carray));


        // now reverse the numbers from idx to end.

        int left = idx;
        int right = carray.length - 1;
        while (left < right) {
            tmp = carray[left];
            carray[left++] = carray[right];
            carray[right--] = tmp;
        }


        return Integer.parseInt(new String(carray));
    }

    public static void main(String[] args) {
        nextGreaterElement(534976);
    }
}