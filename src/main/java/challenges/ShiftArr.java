package challenges;

import java.io.*;
import java.util.*;

class ShiftArr {

    // [9, 12, 17, 20, 4, 5] srch: 2 -> 3 index
    // [17, 2, 4, 5, 12, 9]
    // start:0 end:5 mid: 2



    static int shiftedArrSearch(int[] shiftArr, int num) {
        int start = 0;
        int end = shiftArr.length - 1;

        int mid = (start + end) / 2;
        int pivot = findPivot(shiftArr, start, end, mid);
        System.out.println("pivot:" + pivot);

        return -1;
    }

    static int findPivot(int[] arr, int start, int end, int mid) {
        if(arr[mid] > arr[mid + 1]) {
            return mid;
        }

        //if the first part is sorted, the pivot is on the other side
        if(arr[start] < arr[mid]) {
            start = mid + 1;
            findPivot(arr, start, end, (start+end)/2);
        } else {
            //pivot is on the left side
            end = mid -1;
            findPivot(arr, start, end, (start+end)/2);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sample = new int[] {9, 12, 17, 20, 24, 5};
        int num = 4;
        shiftedArrSearch(sample, num);
    }

}
