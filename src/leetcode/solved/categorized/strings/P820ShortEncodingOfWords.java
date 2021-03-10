package leetcode.solved.categorized.strings;

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
}