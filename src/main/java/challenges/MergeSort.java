package challenges;

import java.util.Arrays;

/**
 * In the first step, we divide the list into two sublists.  (Divide)
 * Then in the next step, we recursively sort the sublists in the previous step.  (Conquer)
 * Finally we merge the sorted sublists in the above step repeatedly to obtain the final list of sorted elements.(Combine)
 */
public class MergeSort {

    public int[] merge_sort(int[] input) {
        if (input.length <= 1) {
            return input;
        }

        int mid = input.length / 2;
        int[] left = merge_sort(Arrays.copyOfRange(input, 0, mid));
        int[] right = merge_sort(Arrays.copyOfRange(input, mid, input.length));
        return merge(left, right);
    }

    private int[] merge(int[] leftList, int[] rightList) {
        int leftListLen = leftList.length;
        int rightListLen = rightList.length;

        int[] result = new int[leftListLen + rightListLen];
        int leftIdx = 0;
        int rightIdx = 0;
        int resultIdx = 0;

        while (leftIdx < leftListLen && rightIdx < rightListLen) {
            if (leftList[leftIdx] < rightList[rightIdx]) {
                result[resultIdx++] = leftList[leftIdx++];
            } else {
                result[resultIdx++] = rightList[rightIdx++];
            }
        }

        while (leftIdx < leftListLen) {
            result[resultIdx++] = leftList[leftIdx++];
        }

        while (rightIdx < rightListLen) {
            result[resultIdx++] = rightList[rightIdx++];
        }

        return result;
    }
}
