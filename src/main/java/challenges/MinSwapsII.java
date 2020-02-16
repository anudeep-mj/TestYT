package challenges;


/* You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates.
You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order
*/

class MinSwapsII {
    static int minimumSwaps(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == i + 1) {
                continue;
            } else {
                swapArr(arr[i], arr[arr[i] - 1]);
                count++;
                i--;
            }
        }
        return count;
    }

    private static void swapArr(int i, int i1) {
        int temp = i;
        i = i1;
        i1 = temp;
    }
}