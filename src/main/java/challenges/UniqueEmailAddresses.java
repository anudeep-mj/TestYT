package challenges;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> emailset = new HashSet<>();
        for (String e : emails) {
            String temp = e.substring(e.indexOf("@"));
            e = e.substring(0, e.indexOf("@"));
            while (e.contains("+")) {
                int idx1 = e.indexOf("+");
                e = e.substring(0, idx1);
            }
            while (e.contains(".")) {
                int idx2 = e.indexOf(".");
                e = e.substring(0, idx2) + e.substring(idx2 + 1);
            }
            emailset.add(e + temp);
        }

        return emailset.size();
    }

    public static void main(String[] args) {
        numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"});
    }
}
