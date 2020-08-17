package challenges;

/**
 * Given a number n, find length of the longest consecutive 1s in its binary representation.
 *
 * Examples :
 * Input : n = 14
 * Output : 3
 * The binary representation of 14 is 1110.
 *
 * Input : n = 222
 * Output : 4
 * The binary representation of 222 is 11011110.
 */
public class LengthOfLongestConsecutive1sInBinary
{
    /*
     The idea is based on the concept that if we AND a bit sequence with a shifted version of itself,
     we’re effectively removing the trailing 1 from every sequence of consecutive 1s.

      11101111   (x)
    & 11011110   (x << 1)
    ----------
      11001110   (x & (x << 1))
        ^    ^
        |    |
   trailing 1 removed

     */
    private static int maxConsecutiveOnes(int x)
    {
        int count = 0;
        while(x != 0) {
            x = x & (x << 1);
        }
        return count;
    }

        private static int maxConsecutiveOnesBF (int x)
    {
        String bin = Integer.toBinaryString(x);
        int count = 0;
        int max = 0;

        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        max = Math.max(count, max);
        return max;
    }

    public static void main(String[] args) {
        maxConsecutiveOnesBF(222);
    }
}
