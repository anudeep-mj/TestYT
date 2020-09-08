package challenges;

public class RepeatedSubstringPattern {

    private static boolean repeatedSubstringPattern(String s) {

        return false;
    }

    public static boolean repeatedSubstringPatternBF(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        for(int i = 0; i <= s.length() / 2; i++) {
            if (s.length() % i + 1 == 0) {
                String tempS = s;
                String subst = s.substring(0, i);
                if(tempS.replace(subst, "").length() == 0) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        repeatedSubstringPatternBF("abab");
    }


}
