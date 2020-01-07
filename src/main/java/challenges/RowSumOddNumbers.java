package challenges;

public class RowSumOddNumbers {
    //rowSumOddNumbers(1); // 1
    //rowSumOddNumbers(2); // 3 + 5 = 8

    public static int rowSumOddNumbers(int n) {
        return n * n * n;
//        if (n == 1) {
//            return 1;
//        } else {
//            for (int i =0; i < n; i++) {
//
//            }
//        }
    }

    public static void main(String[] args) {
        //rowSumOddNumbers(42);
        int sum = rowSumOddNumbers(3);
        System.out.println(sum);
    }

}
