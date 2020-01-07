package challenges;

public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        int i = 0;
        int j = A.length-1;
        int[] c = new int[A.length];
        for (int x = A.length - 1; x >= 0; x--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                c[x] = A[i] * A[i];
                i++;
            } else {
                c[x] = A[j] * A[j];
                j--;
            }
        }

        return c;
    }

}
