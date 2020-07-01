package utils;

import java.util.Arrays;

public class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String word;

    public TrieNode() {
        children = new TrieNode[26];
        Arrays.fill(children, null);
    }
}