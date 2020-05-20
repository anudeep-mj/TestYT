package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 *
 * Example 2:
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 *
 * Example 3:
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }

        long divisor = (long) numerator;
        long dividend = (long) denominator;

        long remainder = divisor % dividend;
        sb.append(divisor / dividend);

        if(remainder == 0) {
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }

            map.put(remainder, sb.length());
            remainder = remainder * 10;
            sb.append(remainder/ dividend);
            remainder = remainder % dividend;
        }

        return sb.toString();
    }


    public static String fractionToDecimalWrong(int numerator, int denominator) {
        double result = (double) numerator / denominator;
        int resultInInt = (int) numerator / denominator;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resultInInt);

        double decimalValuesOfResult = result - resultInInt;

        if (decimalValuesOfResult * 10 > 0) {
            if (decimalValuesOfResult * 100 % 10 != 0) {
                //for unclear ones like 0.3333
                return stringBuilder.append(".(").append((int) (decimalValuesOfResult * 10)).append(")").toString();
            } else {
                //for clean fractions like 0.5 or 10.2
                return stringBuilder.append(".").append((int) (decimalValuesOfResult * 10)).toString();
            }
        } else {
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        fractionToDecimal(100,3);
    }
}
