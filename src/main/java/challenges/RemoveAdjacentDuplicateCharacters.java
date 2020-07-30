package challenges;

public class RemoveAdjacentDuplicateCharacters {
    public static String removeAdjacentDuplicateChars(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        stringBuilder.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
