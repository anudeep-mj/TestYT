package challenges;

import utils.PhoneNumberNode;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberTree {
    private static PhoneNumberNode root = new PhoneNumberNode(' ');

    public static void main(String[] args) {
        PhoneNumberNode node = addPhoneNumber("12345", root);
        PhoneNumberNode node2 = addPhoneNumber("1999", root);
        validatePattern("123");
        validatePattern("12345");
    }

    static boolean lastChar = false;

    public static PhoneNumberNode addPhoneNumber(String input, PhoneNumberNode node) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            lastChar = i == input.length() - 1;
            if (validateChar(c)) {
                PhoneNumberNode newNode = addCharInTree(c, node);
                node = newNode;
            }

        }
        return root;
    }

    private static PhoneNumberNode addCharInTree(char c, PhoneNumberNode node) {
        Map<Character, PhoneNumberNode> children = node.children;
        PhoneNumberNode newNode = null;
        if (children.containsKey(c)) {
            return children.get(c);
        } else {
            newNode = new PhoneNumberNode(c, lastChar);
            children.put(c, newNode);
            node.children = children;
            return newNode;
        }
    }

    public static boolean validatePattern(String input) {
        PhoneNumberNode node = root;

        Map<Character, PhoneNumberNode> children = new HashMap<>();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            children = node.children;
            if (children.containsKey(c)) {
                node = children.get(c);
            }
            count++;
        }
        return count == input.length() && node.end;
    }

    private static boolean validateChar(char c) {
        return Character.isDigit(c);
    }
}
