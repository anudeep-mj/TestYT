package challenges;

import java.util.HashMap;

/**
 * Length of the minimum consecutive subarray with sum = K
 *
 * Input K = 5, buckets = {1 2 2 5 4 1}
 * Output 1
 */
public class LengthOfMinConsecSubarrayOfSumK
{
    public static int minBucketsWithSumK (int[] buckets, int k)
    {
        if (buckets.length == 0) {
            return 0;
        }
        int currSum = 0;

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        while (left <= right && right < buckets.length) {
            int elemAtRight = buckets[right];
            freqMap.put(elemAtRight, freqMap.getOrDefault(elemAtRight, 0) + 1);

            currSum = currSum + elemAtRight;

            while (currSum == k) {
                minLength = Math.min(minLength, right - left + 1);
                freqMap.put(buckets[left], freqMap.get(buckets[left]) - 1);
                if (freqMap.get(buckets[left]) == 0) {
                    freqMap.remove(buckets[left]);
                }
                currSum = currSum - buckets[left];
                left++;
            }
            right++;
        }

        return minLength;
    }
}
