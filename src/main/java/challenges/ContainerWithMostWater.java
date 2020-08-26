package challenges;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithMostWater
{
    public static int maxArea (int[] height)
    {
        if (height.length == 0) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            int len = right - left;
            int breadth = Math.min(height[left], height[right]);
            result = Math.max(result, len * breadth);

            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return result;
    }

    public static void main (String[] args)
    {
        maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
    }
}
