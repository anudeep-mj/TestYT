package challenges;

import utils.TrieConstructor;
import utils.TrieNodeMap;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {

    TrieConstructor trieConstructor;
    TrieNodeMap root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        trieConstructor = new TrieConstructor();
        root = new TrieNodeMap();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        trieConstructor.insertString(word, root);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return trieConstructor.checkStringExists(word, root);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return trieConstructor.checkPrefix(prefix, root);
    }
}
