package challenges;

import java.util.Arrays;

public class ArraySumQuadruplet {
    static int[] findArrayQuadruplet(int[] arr, int s) {
        if (arr.length < 4) {
            return new int[4];
        }
        int[] result = new int[4];
        int length = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < length - 3; i++) {
            for (int j = 0; j < length - 2; j++) {
                int leftover = s - (arr[i] + arr[j]);
                int low = j + 1;
                int high = length - 1;
                while (low <= high) {
                    int tempSum = arr[low] + arr[high];
                    if (tempSum == leftover) {
                        result[0] = arr[i];
                        result[1] = arr[j];
                        result[2] = arr[low];
                        result[3] = arr[high];
                        return result;
                    } else if (tempSum < leftover) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
