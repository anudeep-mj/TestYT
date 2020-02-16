package challenges;

public class RotateArray {
    static int[] rotLeft2(int[] arr, int d) {
        int[] newArr = new int[arr.length];
        int length = arr.length;
        for(int idx = 0; idx <arr.length; idx++) {
            int origIdx = idx;
            int newIdx = getNewIdx(origIdx, length, d);
            newArr[newIdx] = arr[origIdx];
        }
        return newArr;
    }
    static int getNewIdx(int idx, int len, int d) {
        return (idx + (len - d))/len;
    }
    static int[] rotLeft(int[] arr, int d) {
        for(int i = 0; i < arr.length; i++) {
            rotOnceLeft(arr);
        }
        return arr;
    }
    static int[] rotOnceLeft(int[] arr) {
        int first = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = first;
        return arr;
    }
}
