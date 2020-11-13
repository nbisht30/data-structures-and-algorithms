package leetcode.solved.categorized.tries;

import java.util.ArrayList;
import java.util.List;

class P212WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) return new ArrayList<>();

        Trie trie = new Trie();
        trie.addWordsToTrie(words);
        TrieNode root = trie.getRoot();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfsWithTrie(board, root, i, j, result);
            }
        }
        return result;
    }

    void dfsWithTrie(char[][] board,
                     TrieNode node, int i, int j, List<String> result) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] == '#' || node.children[board[i][j] - 'a'] == null)
            return;

        node = node.children[board[i][j] - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        char ch = board[i][j];
        board[i][j] = '#';
        dfsWithTrie(board, node, i + 1, j, result);
        dfsWithTrie(board, node, i - 1, j, result);
        dfsWithTrie(board, node, i, j + 1, result);
        dfsWithTrie(board, node, i, j - 1, result);
        board[i][j] = ch;

    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void addWordsToTrie(String[] words) {
            for (String word : words) {
                TrieNode current = root;
                for (char ch : word.toCharArray()) {
                    int index = ch - 'a';
                    if (current.children[index] == null) {
                        current.children[index] = new TrieNode();
                    }
                    current = current.children[index];
                }
                current.word = word;
            }
        }

        TrieNode getRoot() {
            return this.root;
        }
    }

    class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }
}