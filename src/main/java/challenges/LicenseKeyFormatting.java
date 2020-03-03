package challenges;

public class LicenseKeyFormatting {
    public String formattedLicenseKey(String input, int k) {
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            char c = input.charAt(i);
            int counter = 0;
            if (c != '-') {
                if (counter != k) {
                    sb.append(c);
                    counter++;
                } else {
                    sb.append("-");
                    sb.append(c);
                    counter = 0;
                }
            }
        }
        return sb.reverse().toString();
    }
}
