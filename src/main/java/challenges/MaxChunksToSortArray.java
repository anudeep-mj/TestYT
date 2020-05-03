package challenges;

/**
 * Array A has N distinct integers, sort array A to ascending order. First we divide to it into one or more slices. A slice is a continuous subarray. then we sort the slice.
 * After that, we join the sorted slices in the same order.
 * write a function, solution, that returns the max number of slices for which the algorithm will return a correctly sorted array.
 *
 * ex: given array:[2,4,1,6,5,9,7] => op = 3. array can be split into [2,4,1][6,5][9,7]. sorting them and joining would return a ordered array.
 * max len of input array = 100,000. each elem: [1 .. 1,000,000,000]
 */
public class MaxChunksToSortArray {
    public int maxSplits(int[] inputArray) {
        int maxLeft = Integer.MIN_VALUE;

        int[] rightMin = new int[inputArray.length];
        int arrLen = inputArray.length;

        rightMin[arrLen-1] = inputArray[arrLen -1];
        for (int i = arrLen - 2; i >= 0; i++) {
            rightMin[i] = Math.min(inputArray[i], rightMin[i+1]);
        }

        int count = 0;

        for (int i = 0; i < arrLen; i++) {
            maxLeft = Math.max(maxLeft, inputArray[i]);
            if (i == arrLen-1 || maxLeft <= rightMin[i+1]) {
                count++;
            }
        }

        return count;
    }
}
