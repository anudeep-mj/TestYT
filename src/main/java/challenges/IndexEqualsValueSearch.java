package challenges;

/**
 * Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.
 *
 * Examples:
 *
 * input: arr = [-8,0,2,5,6]
 * output: 2 # since arr[2] == 2
 *
 * input: arr = [-1,0,3,6]
 * output: -1 # since no index in arr satisfies arr[i] == i
 */
public class IndexEqualsValueSearch {
    static int indexEqualsValueSearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < mid) {
                start = mid + 1;
            }
            else if (arr[mid] == mid && (mid == 0 || arr[mid - 1] < mid - 1)) {
                return mid;
            }
            else {
                end = mid -1;
            }
        }
        return -1;
    }

    static int indexEqualsValueSearchLinear(int[] arr) {
        for (int i = 0; i< arr.length; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        indexEqualsValueSearch(new int[]{-8,0,2,5,6});
    }


}
