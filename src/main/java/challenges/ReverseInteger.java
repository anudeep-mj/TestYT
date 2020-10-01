package challenges;

public class ReverseInteger {
    public static Integer reverseInteger(Integer number) {
        if (number < 10) {
            return number;
        }

        int reversedNumber = 0;

        //2345
        while (number != 0) {
            int mod = number % 10;
            if (mod != 0) {
                reversedNumber = reversedNumber * 10 + mod;
            }

            if (mod == 0 && number > 1) {
                reversedNumber = reversedNumber * 10;
            }

            number = number / 10;
        }

        return reversedNumber;
    }


    public static int revInt(int num) {
        int revNum = 0;
        while (num != 0) {
            // 563 % 10 = 3
            int mod = num % 10;
            if(mod != 0) {
                revNum = revNum * 10 + mod;
            } else {
                revNum = revNum * 10;
            }
            num = num / 10;
        }

        return revNum;
    }

    public static void main(String[] args) {
        reverseInteger(504);
    }
}
