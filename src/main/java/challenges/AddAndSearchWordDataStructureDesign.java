package challenges;
/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 *
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWordDataStructureDesign
{
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public AddAndSearchWordDataStructureDesign ()
    {
        root = new TrieNode(new HashMap<>(), false);
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord (String word)
    {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.mappings.containsKey(c)) {
                current.mappings.put(c, new TrieNode(new HashMap<>(), false));
            }
            current = current.mappings.get(c);
        }
        current.end = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */

    public boolean search(String word) {
        return searchWordFromIndex(word, root, 0);
    }

    private boolean searchWordFromIndex (String word, TrieNode node, int idx)
    {
        if (idx == word.length()) {
            return node.end;
        }

        char c = word.charAt(idx);
        if (c != '.') {
            if (!node.mappings.containsKey(c)) {
                return false;
            } else {
                return searchWordFromIndex(word, node.mappings.get(c), idx + 1);
            }
        } else {
            for (Map.Entry<Character, TrieNode> entry : node.mappings.entrySet()) {
                if (searchWordFromIndex(word, entry.getValue(), idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // doesnt work well due to '.'. Try doing it recrusively
    public boolean search2 (String word)
    {
        return searchFromIndex(word);
    }

    private boolean searchFromIndex (String word)
    {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
                if (!current.mappings.containsKey(c)) {
                    return false;
                }
                else {
                    current = current.mappings.get(c);
                }

        }
        return current.end;
    }

    static class TrieNode
    {
        Map<Character, TrieNode> mappings;
        boolean end;

        public TrieNode (Map<Character, TrieNode> mappings, boolean end)
        {
            this.mappings = mappings;
            this.end = end;
        }
    }

    //["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
    //[[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]

    public static void main(String[] args) {
        AddAndSearchWordDataStructureDesign tester = new AddAndSearchWordDataStructureDesign();
        tester.addWord("abc");
        tester.search("a.c");
    }
}
