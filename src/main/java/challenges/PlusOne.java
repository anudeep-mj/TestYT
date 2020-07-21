package challenges;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int remainder = 0;
        boolean last = false;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + remainder;
            if (temp > 9) {
                remainder = 1;
                digits[i] = 0;
                if (i == 0) {
                    last = true;
                }
            } else {
                digits[i] = temp;
                remainder = 0;
            }
        }

        if (last) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }
}
