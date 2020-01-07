package challenges;

import lombok.extern.java.Log;

@Log
public class LargeFactorial {
    public static String Factorial(int n) {
        int[] result = new int[1000];
        result[0] = 1;
        int resultSize = 1;

        for (int index = 2; index <= n; index++) {
            helper(index, result, resultSize);
            //log.info(result.toString());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = resultSize - 1; i >= 0; i--) {
            stringBuilder.append(result[i]);
        }
        System.out.println("Factorial of given number is " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    private static int helper(int index, int[] result, int resultSize) {
        int carry = 0;

        for (int i = 0; i<resultSize; i++) {
            int prod = result[i] * index + carry;
            result[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            result[resultSize] = carry % 10;
            carry = carry /10;
            resultSize++;
        }
        return resultSize;
    }

    public static void main(String[] args) {
        "1307674368000".equals(Factorial(6));
    }
}
