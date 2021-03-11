package leetcode.solved.categorized.tries;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class P820ShortEncodingOfWords {

    // Slow
    public int minimumLengthEncoding(String[] words) {
        // 1. Sort strings in decending order
        Arrays.sort(words, (word1, word2) -> word2.length() - word1.length());
        // 2. Store the encodings in a StringBuilder
        StringBuilder encoding = new StringBuilder();
        
        for(String word : words) {
            if(encoding.indexOf(word + "#") == -1){ // 3. If the encoded word is already present then ignore      
                encoding.append(word + "#");
            }
        }
        
        return encoding.length();
    }

    // Faster
    public int minimumLengthEncodingUsingSet(String[] words) {
        // 1. Put all the words in a set and remove existing duplicates
        Set<String> wordSet = new HashSet<>();

        for(String word : words) {
            wordSet.add(word);
        }

        // 2. Iterate over all the words and remove all the suffixes for each word if they exist in the set
        for(String word : words){
            for(int beginIndex = 1; beginIndex < word.length(); beginIndex++){
                // Starting from 1 so as to not remove the entire word
                String suffix = word.substring(beginIndex);
                wordSet.remove(suffix);
            }
        }

        int sumOfAllLengths = 0;

        for(String word : wordSet) {
            sumOfAllLengths += word.length();
        }

        return wordSet.size() + sumOfAllLengths;
    }

    //Fastest
    class TrieBasedSolution {
        public int minimumLengthEncoding(String[] words) {
            Trie trie = new Trie();
            int length = trie.addWordsToTrieAndGetEncodingLen(words);
            return length;
        }

        class Trie {
            TrieNode root;

            Trie() {
                this.root = new TrieNode();
                root.children = new TrieNode[26];
            }

            int addWordsToTrieAndGetEncodingLen(String[] words) {
                int length = 0;

                for (String word : words) {
                    TrieNode current = root;
                    boolean newBranch = false;
                    int nodesCreated = 0;

                    for (int i = word.length() - 1; i >= 0; i--) {
                        boolean newLevel = false;
                        int index = word.charAt(i) - 'a';

                        if(current.children == null){
                            newLevel = true;
                            current.children = new TrieNode[26];
                        }

                        if (current.children[index] == null) {
                            if(newLevel == false) newBranch = true;
                            current.children[index] = new TrieNode();
                            nodesCreated++;
                        }

                        current = current.children[index];
                    }

                    if(newBranch) length += word.length() + 1;
                    else length += nodesCreated;

                }
                return length;
            }

            TrieNode getRoot() {
                return this.root;
            }
        }

        class TrieNode {
            TrieNode[] children;
        }
    }

}