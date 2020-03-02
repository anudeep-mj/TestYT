package challenges;

public class ToeplitzMatrix {
    static boolean isToeplitz(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) {
            return false;
        }

        int[] firstRowElements = new int[arr[0].length];

        for (int col = 0; col < arr[0].length; col++) {
            firstRowElements[col] = arr[0][col];
            System.out.print("firstRowElements" + col + " = " + arr[0][col] + " ");
        }

        int rowLen = arr.length;
        int colLen = arr[0].length;
        System.out.println("rowLen:" + rowLen);
        System.out.println("colLen:" + colLen);

        for(int i = 1; i < rowLen; i++) {
            System.out.println("i:" + i);
            for(int j = i; j < colLen; j++) {
                System.out.println("i:" + i + " j:" + j);
                int temp = arr[i][j];
                System.out.println("temp:" + temp);
                System.out.println("firstRowElements[j]:" +  firstRowElements[j-i]);

                if (temp != firstRowElements[j-i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {6, 5, 1, 2}};
        System.out.println(isToeplitz(test));
    }
}
