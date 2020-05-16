package leetcode.thirtydaychallengemay;

/**
 * @author Nikhil Bisht
 * @date 16-05-2020
 */
public class Day14_P208ImplementTrie {
    public static void main(String[] args) {

    }


    public class TrieNode {
        char val;
        int count;
        int endsHere;
        TrieNode child[] = new TrieNode[26];
    }

    public class Trie {
        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = getNode('/' - 'a');
        }

        TrieNode getNode(int index) {
            TrieNode newNode = new TrieNode();
            newNode.val = (char) ('a' + index);
            newNode.count = newNode.endsHere = 0;
            return newNode;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode itr = root;
            int index = 0;

            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (itr.child[index] == null) {
                    itr.child[index] = getNode(index);
                }
                itr.child[index].count += 1;
                itr = itr.child[word.charAt(i) - 'a'];
            }
            itr.endsHere += 1;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode itr = root;
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (itr.child[index] == null) return false;
                itr = itr.child[index];
            }
            return itr.endsHere > 0;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode itr = root;

            int index = 0;
            for (int i = 0; i < prefix.length(); i++) {
                index = prefix.charAt(i) - 'a';

                if(itr.child[index] == null) return false;
                itr = itr.child[index];
            }
            return true;
        }
    }
}
