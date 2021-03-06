package leetcode.categorized.tries;

import java.util.HashMap;

class P211AddAndSearchWord {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public P211AddAndSearchWord() {
        root = getNode('/');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode itr = root;
        int index = 0;

        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i);
            if (!itr.child.containsKey(index)) {
                itr.child.put(index, getNode(index));
            }
            itr.child.get(index).count += 1;
            itr = itr.child.get(index);
        }
        itr.endsHere += 1;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return trieSearch(word, root, 0);
    }

    public boolean trieSearch(String word, TrieNode curr, int currPosition) {
        if (word.charAt(currPosition) == '.') {
            boolean res = false;
            TrieNode currentNode;
            for (Integer key : curr.child.keySet()) {
                if (currPosition == word.length() - 1) { // If you've reached the end of the string.
                    currentNode = curr.child.get(key); // Then get the node at 'key'
                    res = res || currentNode.endsHere > 0; // Check if it is the end of a word
                } else if (trieSearch(word, curr.child.get(key), currPosition + 1)) {  // Otherwise, run trieSearch again using the word at 'key'
                    return true;
                }
            }
            return res;
        } else if (curr.child.containsKey((int) word.charAt(currPosition))) {
            curr = curr.child.get((int) word.charAt(currPosition));
            if (currPosition == word.length() - 1) {
                return curr.endsHere > 0;
            } else {
                return trieSearch(word, curr, currPosition + 1);
            }
        } else {
            return false;
        }
    }


    TrieNode getNode(int index) {
        TrieNode newNode = new TrieNode();
        newNode.val = (char) (index);
        newNode.count = newNode.endsHere = 0;
        return newNode;
    }

    public class TrieNode {
        char val;
        int count;
        int endsHere;
        HashMap<Integer, TrieNode> child = new HashMap<>();
    }

}