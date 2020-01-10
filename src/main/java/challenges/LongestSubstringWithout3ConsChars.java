package challenges;

//length of the longest substring without 3 consecutive repeating characters in a row (given a string of only a's and b's).
//aaaaabbabaabaabbb -> 9

public class LongestSubstringWithout3ConsChars {

    public static String getStringWIthout3ConsecutiveLetters (String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input.charAt(0));

        int count = 1;
        int maxCount = 1;
        int tempMaxCount = 1;

        for (int i = 1; i<input.length(); i++) {
            if (input.charAt(i) == input.charAt(i-1)) {
                count++;

                if (count < 3) {
                    stringBuilder.append(input.charAt(i));
                    tempMaxCount++;

                } else {
                    maxCount = Math.max(tempMaxCount, maxCount);
                    tempMaxCount = 1;
                }
            } else {
                stringBuilder.append(input.charAt(i));
                count = 1;
                tempMaxCount++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        getStringWIthout3ConsecutiveLetters("abcd");
    }
}
