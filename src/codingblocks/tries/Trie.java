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
                parent.isTerminal = true;  // since word is completed, make it terminal node
                this.numWords++;
            }
            return;
        }
        char curChar = word.charAt(0);
        String remString = word.substring(1);
        Node child = parent.children.get(curChar);
        if (child == null) {  // if parent node does not have this character
            child = new Node(curChar, false);
            parent.children.put(curChar, child); // add it
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
        if (this.numWords == 0) return false;
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

    public boolean removeWord(String word) {
        if (word.length() == 0) return false;
        int ref[] = new int[]{0};
        Node child = this.root.children.get((word.charAt(0)));
        removeWord(child, word, 1, ref);
        if (ref[0] == 1) return true;
        else return false;
    }

    private Node removeWord(Node curNode, String word, int ind, int[] ref) {
        if (ind == word.length()) {
            if (curNode.isTerminal) {
                ref[0] = 1;
                if (curNode.children.size() > 0) { //word was found but there are other words using this word as prefix
                    curNode.isTerminal = false;
                    return null; //word removed
                } else {
                    return curNode;
                }
            } else {
                return null; //word doesnt exist.
            }
        }
        Node child = curNode.children.get(word.charAt(ind));
        if (child == null) return null; //word doesnt exist.
        Node thisChildsChild = removeWord(child, word, ind + 1, ref);
        if (thisChildsChild != null) {
            curNode.children.remove(thisChildsChild.data);
            if (curNode.isTerminal) return null;
            else return curNode;
        } else return null;
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
