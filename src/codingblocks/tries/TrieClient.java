package codingblocks.tries;

/**
 * @author Nikhil Bisht
 * @date 17-05-2020
 */
public class TrieClient {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("arts");
        trie.addWord("art");
        trie.addWord("bug");
        trie.addWord("boy");
        trie.addWord("sea");
        trie.addWord("seen");
        trie.addWord("see");
        trie.addWord("amit");
/*
        trie.display();
        System.out.println(trie.searchWord("see"));
        System.out.println(trie.searchWord("seen"));
*/

        trie.removeWord("arts");
        trie.removeWord("art");
        trie.removeWord("bug");
        trie.display();
    }
}
