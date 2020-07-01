package challenges;

/**
 * You are given an array of N integers, A1, A2 ,..., AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 * For example,
 *
 * A=[1, 3, -1]
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 */
public class MaximumAbsoluteDifference {
    public static int maxDistance(int[] A) {
        /**
         *
         https://stackoverflow.com/questions/40272649/maximum-absolute-difference-in-an-array
         We can surely use some math here. Try to Expand the Function you are trying to maximise. F(i,j) = |A[i] - A[j]| + |i - j| Expanding it will give us 4 values of F.

         1. A[i] - A[j] + i - j   equals to [A[i] + i] - [A[j]+j]
         2. -A[i] + A[j] + i - j  equals to [-A[i] + i] - [-A[j]+j]
         3. A[i] - A[j] + j - i   equals to [A[i] - i] - [A[j]-j]
         4. -A[i] + A[j] + j - i  equals to [-A[i] - i] - [-A[j]-j]

         Compute the Maximum and Minimum Value of [A[i] + i],[-A[i] + i],[A[i] - i],[-A[i] - i] for all elements in vector/array. call it max1,max2,max3,max4 and min1,min2,min3,min4.

         Your Answer is Max((max1-min1),(max2-min2),(max3-min3),(max4-min4)).

         Here is the Problem Link if anyone is interested :- Problem Link

         Below is my implementation in c++

         int Solution::maxArr(vector<int> &A) {
         int max1 = INT_MIN, max2 = INT_MIN, max3 = INT_MIN, max4 = INT_MIN, ans = INT_MIN;
         int min1 = INT_MAX, min2 = INT_MAX, min3 = INT_MAX, min4 = INT_MAX;
         for (int i=0;i<A.size();i++) {
            max1 = max(max1, A[i] + i);
            max2 = max(max2, A[i] - i);
            max3 = max(max3, -A[i] + i);
            max4 = max(max4, -A[i] - i);

            min1 = min(min1, A[i] + i);
            min2 = min(min2, A[i] - i);
            min3 = min(min3, -A[i] + i);
            min4 = min(min4, -A[i] - i);
         }

         ans = max(ans,max1 - min1);
         ans = max(ans,max2 - min2);
         ans = max(ans,max3 - min3);
         ans = max(ans,max4 - min4);

         return ans;
         }

         */

        return -1;
    }

    public static int maxDistanceBF(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length-1; i++) {
            for (int j = i; j < A.length; j++) {
                result = Math.max(result, calcDist(i, j, A));
            }
        }
        return result;
    }

    private static int calcDist(int i, int j, int[] A) {
        return Math.abs(A[i] - A[j]) + Math.abs(i - j);
    }

    public static void main(String[] args) {
        maxDistance(new int[]{1,3,-1});
    }
}
