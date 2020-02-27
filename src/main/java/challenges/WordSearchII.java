package challenges;

//Given a 2D board and a list of words from the dictionary, find all words in the board.
//        Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//        Example:
//        Input:
//        board = [
//        ['o','a','a','n'],
//        ['e','t','a','e'],
//        ['i','h','k','r'],
//        ['i','f','l','v']
//        ]
//        words = ["oath","pea","eat","rain"]
//
//        Output: ["eat","oath"]
//
//
//        Note:
//        All inputs are consist of lowercase letters a-z.
//        The values of words are distinct.


import utils.TrieNode;

import java.util.ArrayList;
import java.util.List;

class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();

        for(int row = 0; row < board[0].length; row++) {
            for(int col = 0; col < board.length; col++) {
                dfs(row, col, board, root, res);
            }
        }

        return res;
    }

    public void dfs(int row, int col, char[][] board, TrieNode node, List<String> res) {
        char c = board[row][col];
        if(c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];

        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }


        if(row > 0) {
            dfs(row-1, col, board, node, res);
        }
        if(col > 0) {
            dfs(row, col - 1, board, node, res);
        }
        if(row < board[0].length- 1) {
            dfs(row + 1, col, board, node, res);
        }
        if(col < board.length - 1) {
            dfs(row, col + 1, board, node, res);
        }
        board[row][col] = c;
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode p = root;
            for(char c : word.toCharArray()) {
                int i = c - 'a';
                if(p.children[i] != null) {
                    p.children[i] = new TrieNode();
                }
                p = p.children[i];
            }
            p.word = word;
        }
        return root;
    }
}
