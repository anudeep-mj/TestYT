package challenges;

/**
 * There is a forum that limits to K characters per entry. In this task your job is to implement an algo for cropping messages that are too long.
 * You are given a message, consisting of english alphabets and spaces that might be longer than the limit.
 * Your algo should crop a number of words from the end of the message, keeping in mind that:
 * it may not crop out part of a word.
 * the output message may not end with a space.
 * the output message may not exceed the K-characater limit.
 * the output message must be as long as possible.
 * in some cases, the algo might have to crop away the entire message, outputting an empty string.
 * eg: "Codility we test coders". K = 14. OP: "Codility we". eg wrong output : "Codility we te"
 */
public class CropWords {
    public static String cropWords(String messageInput, int k) {
        if (k == 0 || messageInput.length() == 0) {
            return "";
        }

        if (messageInput.length() <= k) {
            return messageInput;
        }

        char c = messageInput.charAt(k-1);
        if (c == ' ') {
            return messageInput.trim();
        } else {
            if (messageInput.charAt(k) == ' ') {
                return messageInput.trim();
            } else {
                for (int i = k-1; i >=0; i--) {
                    if (messageInput.charAt(i) == ' ') {
                        return messageInput.substring(0, i).trim();
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        cropWords("Codility we test coders", 14);
    }
}
