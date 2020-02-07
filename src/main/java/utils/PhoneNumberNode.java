package utils;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberNode {
    public char val;
    public Map<Character, PhoneNumberNode> children;
    public boolean end;
    public PhoneNumberNode(char val) {
        this.val = val;
        children = new HashMap<>();
    }

    public PhoneNumberNode(char val, boolean end) {
        this.val = val;
        this.end = end;
        children = new HashMap<>();
    }
}
