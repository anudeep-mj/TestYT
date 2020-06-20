package challenges;

/**
 * Create a trie and verify the insert, search and startsWith functions
 */

public class TrieVerify {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.search("aaa");
        trie.search("abcd");
        trie.startsWith("ab");
    }
}
