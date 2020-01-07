package challenges;

/*
array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]

00 01 02 -> 12 22 -> 21 20 -> 10 11


 */
public class Snail {
    public static int[] snail(int[][] array) {
        //this assumption was wrong. should ask the interviewer if the matrix is always a square ?
        int[] result = new int[array.length * array[0].length];

        int rowStart = 0;
        int rowEnd = array[0].length - 1;

        int colStart = 0;
        int colEnd = array.length - 1;

        int count = 0;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result[count++] = array[rowStart][i];
            }

            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                result[count++] = array[i][colEnd];
            }

            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result[count++] = array[rowEnd][i];
                }
            }

            rowEnd--;

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result[count++] = array[i][colStart];
                }
            }

            colStart++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        snail(array);
    }
}
