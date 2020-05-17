package codingblocks.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Nikhil Bisht
 * @date 17-05-2020
 */
public class Trie {
    private int numWords;
    private Node root;

    Trie() {
        this.root = new Node('\0', false);
        this.numWords = 0;
    }

    public int getNumWords() {
        return this.numWords;
    }

    public void addWord(String word) {
        this.addWord(this.root, word);
    }

    private void addWord(Node parent, String word) {
        if (word.length() == 0) {
            if (parent.isTerminal) {
                // word already exists
            } else {
                parent.isTerminal = true;
                this.numWords++;
            }
            return;
        }
        char curChar = word.charAt(0);
        String remString = word.substring(1);
        Node child = parent.children.get(curChar);
        if (child == null) {
            child = new Node(curChar, false);
            parent.children.put(curChar, child);
        }
        this.addWord(child, remString);
    }

    public void display() {
        this.display(this.root, "");
    }

    private void display(Node node, String outputSoFar) {
        if (node.isTerminal) {
            System.out.println(outputSoFar);
        }
        Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
        for (Map.Entry<Character, Node> entry : entries) {
            this.display(entry.getValue(), outputSoFar + entry.getKey());
        }
    }

    public boolean searchWord(String word) {
        if(this.numWords == 0) return false;
        return searchWord(this.root, word, 0);
    }

    private boolean searchWord(Node node, String word, int ind) {
        if (ind == word.length()) {
            return node.isTerminal;
        }
        Node thisChild = node.children.get(word.charAt(ind));
        if (thisChild == null) return false;
        return searchWord(thisChild, word, ind + 1);
    }

    private class Node {
        char data;
        HashMap<Character, Node> children;
        boolean isTerminal;

        Node(char data, boolean isTerminal) {
            this.data = data;
            this.isTerminal = isTerminal;
            children = new HashMap<>();
        }
    }
}
