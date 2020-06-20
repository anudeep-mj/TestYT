package utils;

public class TrieConstructor {

    public boolean insertString(String input, TrieNodeMap root) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!root.getValsMap().containsKey(c)) {
                TrieNodeMap newNode = new TrieNodeMap();
                root.getValsMap().put(c, newNode);
            }
            root = root.getValsMap().get(c);
        }
        if (root.isEnd()) {
            //string already exists in trie
            return false;
        } else {
            root.setEnd(true);
            return true;
        }
    }

    public boolean checkStringExists(String input, TrieNodeMap root) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!root.getValsMap().containsKey(c)) {
                return false;
            } else {
                root = root.getValsMap().get(c);
            }
        }
        return root.isEnd();
    }

    public boolean checkPrefix(String prefix, TrieNodeMap root) {
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!root.getValsMap().containsKey(c)) {
                return false;
            } else {
                root = root.getValsMap().get(c);
            }
        }
        return true;
    }
}
