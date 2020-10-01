package challenges;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * The elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int[] maxRightArr = new int[height.length];
        int[] maxLeftArr = new int[height.length];

        int maxLeft = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeft = Math.max(height[i-1], maxLeft);
            maxLeftArr[i] = maxLeft;
        }

        int maxRight = 0;
        maxRightArr[height.length-1] = 0;
        for (int i = height.length-2; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i+1]);
            maxRightArr[i] = maxRight;
        }

        int result = 0;
        for(int i = 0; i < height.length; i++) {
            int min = Math.min(maxLeftArr[i], maxRightArr[i]);
            if ((min - height[i]) >= 0) {
                result = result + (min - height[i]);
            }
        }
        return result;
    }

    public int trap2(int[] height) {
        if(height.length == 0) {
            return 0;
        }

        int result = 0;

        int[] mxArr = new int[height.length];

        int mxLeft = 0;
        for (int i = 1; i < height.length; i++) {
            mxLeft = Math.max(mxArr[i-1], mxLeft);
            mxArr[i] = mxLeft;
        }

        int mxRt = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            mxRt = Math.max(mxRt, height[i + 1]);
            int min = Math.min(mxArr[i], mxRt);
            if (min - height[i] > 0) {
                result = result + (min - height[i]);
            }
        }

        return result;
    }
}
