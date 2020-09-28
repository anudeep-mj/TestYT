package challenges;

import java.math.BigInteger;

public class GreatestCommonDivisor
{
    public int getGCD (int a, int b)
    {
        if (b == 0) {
            return a;
        }
        else {
            return getGCD(b, a % b);
        }
    }

    public int getGCD2 (int a, int b)
    {
        BigInteger ba = BigInteger.valueOf(a);
        BigInteger bb = BigInteger.valueOf(b);
        BigInteger bg = ba.gcd(bb);
        return bg.intValue();
    }
}
