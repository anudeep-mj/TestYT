package challenges;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 */
public class ProductOfArrayExceptSelf {

    public static int[] produ(int[] nums) {
        //[7,2,3,4]
        int leftProduct = 1;
        int[] dp = new int[nums.length];

        //[1,7,14,42]
        for (int i = 0; i < nums.length; i++) {
            dp[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;
        //[, 14*4, 42] rp = 1 * 4
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = dp[i] * rightProduct;
            rightProduct = nums[i] *  rightProduct;
        }

        return dp;
    }

    public static int[] productExceptSelfConstantSpaceComplexity(int[] nums) {
        int[] result = new int[nums.length];

        //[7,2,3,4]
        //[1,7,14,42]
        //[]
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = nums[i-1] * result[i-1];
        }

        int tempRightPointer = nums[result.length - 1];
        for (int j = result.length - 2; j >=0; j--) {
            result[j] = result[j] * tempRightPointer;
            tempRightPointer = tempRightPointer * nums[j];
        }

        return result;
    }


    public static int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        for (int i = 0; i < leftProduct.length; i++) {
            leftProduct[i] = 1;
            rightProduct[i] = 1;
        }

        //[1,7,14,42]
        for (int i = 1; i < leftProduct.length; i++) {
            leftProduct[i] = nums[i-1] * leftProduct[i-1];
        }

        for (int j = leftProduct.length - 2; j >= 0; j--) {
            rightProduct[j] = nums[j+1] * rightProduct[j+1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
    }

    public static void main(String[] args) {
        productExceptSelfConstantSpaceComplexity(new int[]{1,2,3,4});
        //productExceptSelf(new int[]{1,2,3,4});
    }
}
