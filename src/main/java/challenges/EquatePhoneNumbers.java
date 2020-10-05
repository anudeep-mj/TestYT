package challenges;

import java.util.HashSet;
import java.util.Set;

public class EquatePhoneNumbers
{
    Set<String> buffer;

    public boolean equalPhoneNums(String num1, String num2) {
        buffer = new HashSet<>();

        num1 = sanitizePhoneNum(num1);
        buffer.add(num1);

        num2 = sanitizePhoneNum(num2);
        return buffer.contains(num2);
    }

    private String sanitizePhoneNum (String num1)
    {
        StringBuilder sb = new StringBuilder();
        for (char c : num1.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
