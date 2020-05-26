package challenges;

public class ReverseWords {
    public static String reverseStringByWords(String s) {
        String[] split = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuilder.append(split[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        reverseStringByWords("hello world new");
    }
}
