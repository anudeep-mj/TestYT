package challenges;

import java.io.*;

class MinificationString {
    private static String minificationString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        if(str.length() == 0) {
            return "";
        }
        sb.append(str.charAt(0));
        for(int i = 1; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(ch == str.charAt(i-1)) {
                count++;
            } else {
                if(count != 1) {
                    sb.append(count);
                }
                sb.append(ch);
                count = 1;
            }
        }
        if(count != 1) {
            sb.append(count);
        }
        return sb.toString();
    }
    public static void main (String[] args) {
        //System.out.println("Hello Java");
        String example = "aabcjjkaa";
        System.out.println(minificationString(example));
    }
}
