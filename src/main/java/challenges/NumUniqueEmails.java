package challenges;

import java.util.HashSet;

public class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        int len = emails.length;
        HashSet<String> hashSet = new HashSet<>();
        if (len == 0) return 0;
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            StringBuilder stringBuilder = new StringBuilder();
            for (int idx = 0; idx < email.length(); idx++) {
                char c = email.charAt(idx);
                if (c == '.') {
                    continue;
                } else if (c == '+') {
                    char temp = email.charAt(idx);
                    while (temp != '@') {
                        temp = email.charAt(idx);
                        idx++;
                    }
                } else {
                    stringBuilder.append(c);
                }
            }
            hashSet.add(stringBuilder.toString());
        }
        return hashSet.size();
    }
}
