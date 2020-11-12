package leetcode.solved.categorized.tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class P212WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) return new ArrayList<>();

        Trie trie = new Trie();
        trie.addWordsToTrie(words);
        TrieNode root = trie.getRoot();

        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfsWithTrie(board, visited, root, i, j, result);
            }
        }
        return new ArrayList<>(result);
    }

    void dfsWithTrie(char[][] board, boolean[][] visited,
                     TrieNode node, int i, int j, Set<String> result) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || visited[i][j] || node.children[board[i][j] - 'a'] == null)
            return;

        node = node.children[board[i][j] - 'a'];
        if (node.isWord) {
            result.add(node.currentWord);
        }

        visited[i][j] = true;
        dfsWithTrie(board, visited, node, i + 1, j, result);
        dfsWithTrie(board, visited, node, i - 1, j, result);
        dfsWithTrie(board, visited, node, i, j + 1, result);
        dfsWithTrie(board, visited, node, i, j - 1, result);
        visited[i][j] = false;

    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void addWordsToTrie(String[] words) {
            for (String word : words) {
                TrieNode current = root;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (current.children[ch - 'a'] == null) {
                        current.children[ch - 'a'] = new TrieNode();
                    }
                    sb.append(ch);
                    current = current.children[ch - 'a'];
                    current.currentWord = sb.toString();
                }
                current.isWord = true;
            }
        }

        TrieNode getRoot() {
            return this.root;
        }
    }

    class TrieNode {
        boolean isWord;
        String currentWord;
        TrieNode[] children = new TrieNode[26];
    }
}